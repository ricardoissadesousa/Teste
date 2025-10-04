package com.example.planetas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Inicializa as views apenas quando necessário
    private val imagem: ImageView by lazy { findViewById(R.id.img) }
    private val combo: Spinner by lazy { findViewById(R.id.spinner) }
    val planetas = Planetas()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        combo.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, planetas.getPlaneta()
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        // Se selecionar algum planeta, atualiza a imagem
        combo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                posicao: Int,
                id: Long
            ) {
                // Atualiza a imagem
                planetas.getImagemPlaneta(posicao)?.let { imagem.setImageResource(it) }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}

