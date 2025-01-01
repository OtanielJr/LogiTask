package com.example.logitask

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import java.util.Calendar

class CreateUser2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user2)

       var continuarBtn = findViewById<Button>(R.id.next_step_btn)

        continuarBtn.setOnClickListener {
            // Adicionar sistema de rotas
        }
    }
}
