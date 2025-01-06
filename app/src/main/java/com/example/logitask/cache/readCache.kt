    package com.example.logitask.cache

    import android.content.Context
    import android.util.Log
    import com.google.gson.Gson
    import com.google.gson.reflect.TypeToken
    import com.example.logitask.User
    import java.io.File

    data class ApiResponse(
        val status: String,
        val data: User // O campo 'data' agora é um único objeto User
    )

    public fun getUserDataFromCache(context: Context): User?{
        var userData: User? = null
        try {
            val cacheFile = File(context.cacheDir, "userCache.json")

            if (cacheFile.exists()) {
                val userCache = cacheFile.readText()
                Log.d("getUserDataFromCache", "Dados do cache lidos com sucesso: $userCache")



                val apiResponse = Gson().fromJson(userCache, ApiResponse::class.java)
                userData = apiResponse.data

            } else {
                Log.d("getUserDataFromCache", "Ficheiro de cache não encontrado")
                null
            }
        } catch(e: Exception){
            Log.e("getUserDataFromCache", "Erro ao ler os dados do cache: ${e.message}")
            null
        }
        return userData
    }



