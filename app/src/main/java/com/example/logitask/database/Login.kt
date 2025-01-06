package com.example.logitask.database

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import login
import java.io.File

suspend fun doLogin(data: List<String>, context: Context): Boolean {
    var success: Boolean
    withContext(Dispatchers.IO) {
        val email = data[0]
        val pass = data[1]

        val response = login(email, pass, context) // Chama a função `login` do outro arquivo

        if (response.isNotEmpty()) {
            // Serializar os dados do usuário em JSON e salvar em cache

            success = true

        } else {
            Log.e("doLogin", "Resposta da API vazia ou inválida.")
            success = false
        }
    }
    return success
}
