package com.example.logitask

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logitask.navigationSystem.Routes

class ManageColaborators: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gerir_colaboradores)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addColaboratorBtn = findViewById<AppCompatButton>(R.id.adicionarColaboradorBtn)

        addColaboratorBtn.setOnClickListener {
            Log.d("CreateUser1","CreateUser1 clicked")
            Routes.routeNavigation(this,"CreateUser1")
        }
    }
}