package com.example.movieapp.data.room

import androidx.room.Insert
import androidx.room.Query
import com.example.movieapp.data.model.Filmler

@androidx.room.Dao
interface Dao {
    @Query("SELECT * FROM filmler")
    suspend fun filmleriYukle() : List<Filmler>


    @Query("SELECT * FROM filmler WHERE name_film = :aramaKelimesi")
    suspend fun ara(aramaKelimesi : String) : List<Filmler>


}