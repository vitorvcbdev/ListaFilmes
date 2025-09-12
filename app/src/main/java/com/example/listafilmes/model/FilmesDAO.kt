package com.example.listafilmes.model

interface FilmesDAO {
    fun adicionarFilme(filme: Filmes)
    fun obterFilmes(): List<Filmes>
}