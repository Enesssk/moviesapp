package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.Filmler
import com.example.movieapp.data.room.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var dao : Dao) {
    suspend fun filmleriYukle() : List<Filmler> = withContext(Dispatchers.IO){
        return@withContext dao.filmleriYukle()
    }
    suspend fun ara(aramaKelimesi : String) : List<Filmler> = withContext(Dispatchers.IO){
        return@withContext dao.ara(aramaKelimesi)
    }
}