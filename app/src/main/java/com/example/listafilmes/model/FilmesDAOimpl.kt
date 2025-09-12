package com.example.listafilmes.model

class FilmesDAOimpl: FilmesDAO {

    companion object{
        val filmes = mutableListOf<Filmes>()
    }

    override fun adicionarFilme(filme: Filmes) {
        filmes.add(filme)
    }

    override fun obterFilmes(): List<Filmes> {
        return filmes
    }

}