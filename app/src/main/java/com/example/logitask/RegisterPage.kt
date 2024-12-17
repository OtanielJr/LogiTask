package com.example.logitask

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import com.example.logitask.navigationSystem.Routes

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gotologin = findViewById<TextView>(R.id.login_redirect_link)
        gotologin.setOnClickListener{
            Routes.routeNavigation(this,"Login")
        }


    }
    fun registerClick(view: View){
        val data = fieldVerify()
        if(data != null){
            Log.d("Criado","Criado")
        }

    }

    private fun fieldVerify():List<String>?{
        val emailInput = findViewById<EditText>(R.id.emailInsert)
        val passInput = findViewById<EditText>(R.id.PasswordInsert)
        val pass2Input = findViewById<EditText>(R.id.PasswordRepeatInsert)


        var email : String
        var pass : String
        var pass2 : String


        var isValid : Boolean


        isValid = true
        email = emailInput.text.toString()
        pass = passInput.text.toString()
        pass2 = pass2Input.text.toString()

        if(emailInput.text.isEmpty()){
            emailInput.error = "Este campo é obrigatório"
            isValid = false
        }
        if(passInput.text.isEmpty()){
            passInput.error = "Este campo é obrigatório"
            isValid = false
        }
        if(pass2Input.text.isEmpty()){
            pass2Input.error = "Este campo é obrigatório"
            isValid = false
        }
        if(pass != pass2){
            pass2Input.error = "Esta password não é igual com a anterior"
            isValid = false
        }

        return if(isValid){
            listOf(email,pass,pass2)
        }else{
            null
        }
    }
}