package com.example.logitask

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class CreateUser1 : AppCompatActivity() {

    // Variáveis para o layout clicável e o texto
    lateinit var dateLayout: LinearLayout
    lateinit var selectedDateTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user1)

        // Inicializar os elementos do layout
        dateLayout = findViewById(R.id.dateLayout)
        selectedDateTV = findViewById(R.id.dateText)

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
    }
}
