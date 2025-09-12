package com.example.listafilmes.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listafilmes.R
import com.example.listafilmes.adapter.FilmesAdapter
import com.example.listafilmes.model.FilmesDAOimpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaFilmesActivity : AppCompatActivity(R.layout.activity_lista_filmes) {
    private val dao = FilmesDAOimpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rvFilmes = findViewById<RecyclerView>(R.id.rv_filmes)
        val filmes = dao.obterFilmes()
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        rvFilmes.layoutManager = LinearLayoutManager(this)
        rvFilmes.adapter = FilmesAdapter(filmes)

        fabVolta.setOnClickListener {
            finish()
        }
    }
}