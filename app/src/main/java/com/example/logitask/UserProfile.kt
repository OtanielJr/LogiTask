package com.example.logitask


import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity




class UserProfile: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)

        // Declarar variaveis
        val returnArrow = findViewById<ImageView>(R.id.goBackArrowBtn)
        val account = findViewById<LinearLayout>(R.id.account_layout)
        val notifications = findViewById<LinearLayout>(R.id.notifications_layout)
        val helpCenter = findViewById<LinearLayout>(R.id.help_layout)

        returnArrow.setOnClickListener {

            // Logica para voltar à página anterior
        }

        account.setOnClickListener {

        }
        notifications.setOnClickListener {

        }
        helpCenter.setOnClickListener {

        }


    }

}
