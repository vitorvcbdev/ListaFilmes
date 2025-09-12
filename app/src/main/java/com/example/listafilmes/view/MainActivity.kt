package com.example.listafilmes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listafilmes.R
import com.example.listafilmes.model.Filmes
import com.example.listafilmes.model.FilmesDAO
import com.example.listafilmes.model.FilmesDAOimpl

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = FilmesDAOimpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt_titulo = findViewById<EditText>(R.id.edt_titulo)
        val cb_terror = findViewById<CheckBox>(R.id.cb_terror)
        val cb_comedia = findViewById<CheckBox>(R.id.cb_comedia)
        val cb_suspense = findViewById<CheckBox>(R.id.cb_suspense)
        val cb_romance = findViewById<CheckBox>(R.id.cb_romance)
        val cb_aventura = findViewById<CheckBox>(R.id.cb_aventura)
        val cb_drama = findViewById<CheckBox>(R.id.cb_drama)
        val sb_avaliacao = findViewById<SeekBar>(R.id.sb_avaliacao)
        val btn_cadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val txv_avaliacao = findViewById<TextView>(R.id.txv_avaliacao)

        sb_avaliacao.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txv_avaliacao.text = "Avaliação: $progress" // Atualiza o valor mostrado no TextView
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btn_cadastrar.setOnClickListener{
            val titulo = edt_titulo.text.toString()
            val avaliacao = sb_avaliacao.progress
            val generoList = mutableListOf<String>()
            if (cb_terror.isChecked) generoList.add("Terror")
            if (cb_comedia.isChecked) generoList.add("Comédia")
            if (cb_suspense.isChecked) generoList.add("Suspense")
            if (cb_romance.isChecked) generoList.add("Romance")
            if (cb_aventura.isChecked) generoList.add("Aventura")
            if (cb_drama.isChecked) generoList.add("Drama")
            val genero = generoList.joinToString(", ")
            dao.adicionarFilme(Filmes(titulo, genero, avaliacao))

            val intent = Intent(this, ListaFilmesActivity::class.java)
            startActivity(intent)}
    }

}