package com.example.logitask.database

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import register
import java.io.File

suspend fun doRegister(data: List<String>, context: Context): Boolean {
    var success: Boolean
    withContext(Dispatchers.IO) {
        val email = data[0]
        val pass = data[1]
        val name = data[2]
        val username = data[3]
        Log.d("Sending email:" ,email)
        Log.d("Sending pass:" ,pass)
        Log.d("Sending name:",name)
        Log.d("Sending username:", username)

        val response = register(email, pass, name, username)

        if (response) {
            success = true

        } else {
            Log.e("doRegister", "Resposta da API false.")
            success = false
        }
    }
    return success
}
