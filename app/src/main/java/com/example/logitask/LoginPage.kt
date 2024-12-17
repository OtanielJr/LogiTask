package com.example.logitask

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logitask.navigationSystem.Routes
import com.example.logitask.database.Login

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var criarConta = findViewById<TextView>(R.id.register_redirect_link)
        criarConta.setOnClickListener{
            Routes.routeNavigation(this, "Register")
        }


    }


    fun loginClick(view: View){
        val data = fieldsVerify()
        if(data != null){
            Login(data)
        }
        //Routes.routeNavigation(this,"Home")

    }

    private fun fieldsVerify() : List<String>?{

        var emailInput = findViewById<EditText>(R.id.emailInput)
        var passInput = findViewById<EditText>(R.id.PasswordInput)
        var emailValue : String
        var passValue : String

        var isValid : Boolean

        isValid = true

            emailValue = emailInput.text.toString()
            passValue = passInput.text.toString()

            if(emailInput.text.isEmpty()){
                emailInput.error = "Este campo é obrigatório"
                isValid = false
            }
            if(passInput.text.isEmpty()){
                passInput.error = "Este campo e obrigatório"
                isValid = false
            }



        return if (isValid) {
            listOf(emailValue, passValue)
        } else {
            null
        }


    }



}