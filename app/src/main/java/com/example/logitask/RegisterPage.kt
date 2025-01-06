package com.example.logitask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.logitask.database.doLogin
import com.example.logitask.database.doRegister
import com.example.logitask.navigationSystem.Routes
import kotlinx.coroutines.launch

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
            lifecycleScope.launch {
                val success = doRegister(data, this@RegisterPage)
                if(success) {
                    Toast.makeText(
                        this@RegisterPage,
                        "Registo realizado com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    // Redirecionar para a próxima página
                    startActivity(Intent(this@RegisterPage, HomeActivity::class.java))
                }else{
                    Toast.makeText(
                        this@RegisterPage,
                        "Erro ao realizar registo. Verifique os campos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    private fun fieldVerify():List<String>?{

        val emailInput = findViewById<EditText>(R.id.emailInsert)
        val nameInput = findViewById<EditText>(R.id.nameInsert)
        val userNameInput = findViewById<EditText>(R.id.userNameInsert)
        val passInput = findViewById<EditText>(R.id.PasswordInsert)
        val pass2Input = findViewById<EditText>(R.id.PasswordRepeatInsert)


        var email : String
        var name : String
        var userName : String
        var pass : String
        var pass2 : String


        var isValid : Boolean


        isValid = true
        name = nameInput.text.toString()
        userName = userNameInput.text.toString()
        email = emailInput.text.toString()
        pass = passInput.text.toString()
        pass2 = pass2Input.text.toString()


        if(nameInput.text.isEmpty()){
            emailInput.error = "Este campo é obrigatório"
            isValid = false
        }
        if(userNameInput.text.isEmpty()){
            emailInput.error = "Este campo é obrigatório"
            isValid = false
        }
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
            listOf(email,pass2,name,userName)
        }else{
            null
        }
    }
}