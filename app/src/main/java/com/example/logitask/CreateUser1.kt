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

class CreateUser1 : AppCompatActivity() {

    lateinit var dateLayout: LinearLayout
    lateinit var selectedDateTV: TextView
    lateinit var nacionalidadeSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user1)

        // Inicializar os elementos do layout
        dateLayout = findViewById(R.id.dateLayout)
        selectedDateTV = findViewById(R.id.dateText)
        nacionalidadeSpinner = findViewById(R.id.nacionalidade_spinner)

        // Botão para seguir para a proxima página
        var continuarBtn = findViewById<Button>(R.id.next_step_btn)

        continuarBtn.setOnClickListener {
            // Adicionar sistema de rotas
        }

        // Definir o clique no layout para abrir o DatePickerDialog
        dateLayout.setOnClickListener {
            // Obter a instância do calendário
            val c = Calendar.getInstance()

            // Recuperar o ano, mês e dia
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // Criar o DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Atualizar o TextView com a data selecionada
                    selectedDateTV.text =
                        "$selectedDay-${selectedMonth + 1}-$selectedYear"
                },
                year,
                month,
                day
            )
            // Exibir o diálogo
            datePickerDialog.show()
        }

        // Lista de nacionalidades temporárias para o Spinner
        // Muda isto no backend se quiseres
        val nacionalidades = listOf("Brasil", "Portugal", "Angola", "Moçambique", "França")

        // Criando o ArrayAdapter para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nacionalidades)

        // Definindo o layout do dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Associar o ArrayAdapter ao Spinner
        nacionalidadeSpinner.adapter = adapter

        // Configurar um listener para capturar a seleção do usuário
        nacionalidadeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val itemSelecionado = parent.getItemAtPosition(position) as String

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }
}
