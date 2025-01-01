package com.example.logitask

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CreateUser3: AppCompatActivity() {

    lateinit var idenntificacaoSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user3)

        // Inicializar os elementos do layout

        idenntificacaoSpinner = findViewById(R.id.identificacao_spinner)

        // Botão para seguir para a proxima página
        var continuarBtn = findViewById<Button>(R.id.finalizar_btn)

        continuarBtn.setOnClickListener {
            // Adicionar sistema de rotas
        }

        // Lista de nacionalidades temporárias para o Spinner
        // Muda isto no backend se quiseres
        val nacionalidades = listOf("Residência", "Morada")

        // Criando o ArrayAdapter para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nacionalidades)

        // Definindo o layout do dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Associar o ArrayAdapter ao Spinner
        idenntificacaoSpinner.adapter = adapter

        // Configurar um listener para capturar a seleção do usuário
        idenntificacaoSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val itemSelecionado = parent.getItemAtPosition(position) as String

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

}