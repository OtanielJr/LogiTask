package com.example.logitask.database

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import login
import java.io.File

suspend fun doLogin(data: List<String>): Boolean {
    var success: Boolean
    withContext(Dispatchers.IO) {
        val email = data[0]
        val pass = data[1]

        val response = login(email, pass) // Chama a função `login` do outro arquivo

        if (response.isNotEmpty()) {
            // Serializar os dados do usuário em JSON e salvar em cache
            val gson = Gson()
            val json = gson.toJson(response)

            try {
                val cacheFile = File("/data/data/com.example.logitask/cache", "userCache.json")
                cacheFile.writeText(json)
                Log.d("doLogin", "Dados do usuário salvos em cache com sucesso.")
                success = true
            } catch (e: Exception) {
                Log.e("doLogin", "Erro ao salvar dados em cache: ${e.message}")
                success = false
            }
        } else {
            Log.e("doLogin", "Resposta da API vazia ou inválida.")
            success = false
        }
    }
    return success
}
