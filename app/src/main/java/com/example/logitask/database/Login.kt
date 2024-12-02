package com.example.logitask.database
import android.util.Log

class Login(data: List<String>) {
    val pass = data[0]
    val email = data[0]

    init{
        Log.d("LoginClass", "Senha: $pass, Email: $email")
    }



}