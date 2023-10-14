package com.example.movieapp.data.room

import androidx.room.RoomDatabase
import com.example.movieapp.data.model.Filmler

@androidx.room.Database(entities = [Filmler::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getFilmlerDao() : Dao
}