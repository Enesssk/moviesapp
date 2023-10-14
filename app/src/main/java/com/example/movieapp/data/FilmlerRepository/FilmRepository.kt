package com.example.movieapp.data.FilmlerRepository

import com.example.movieapp.data.datasource.FilmlerDataSource
import com.example.movieapp.data.model.Filmler

class FilmRepository(var fds : FilmlerDataSource) {
    suspend fun filmleriYukle() : List<Filmler> {
        return fds.filmleriYukle()
    }
    suspend fun ara(aramaKelimesi : String) : List<Filmler> {
        return fds.ara(aramaKelimesi)
    }


}