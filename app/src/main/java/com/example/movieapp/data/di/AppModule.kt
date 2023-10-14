package com.example.movieapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.FilmlerRepository.FilmRepository
import com.example.movieapp.data.datasource.FilmlerDataSource
import com.example.movieapp.data.room.Dao
import com.example.movieapp.data.room.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFilmlerDataSource(dao:Dao) : FilmlerDataSource{
        return FilmlerDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideFilmlerRepository(fds:FilmlerDataSource):FilmRepository{
        return FilmRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFilmlerDao(@ApplicationContext context: Context) : Dao {
        val vt=Room.databaseBuilder(context,Database::class.java,"filmler.db").createFromAsset("filmler.db").build()
        return vt.getFilmlerDao()
    }



}