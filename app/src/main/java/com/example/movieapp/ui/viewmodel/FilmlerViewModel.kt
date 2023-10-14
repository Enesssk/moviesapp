package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.FilmlerRepository.FilmRepository
import com.example.movieapp.data.model.Filmler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmlerViewModel @Inject constructor(var repo:FilmRepository) : ViewModel(){

    var filmlerListesi= MutableLiveData<List<Filmler>>()

    init {
        filmleriYukle()
    }


    fun filmleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            filmlerListesi.value=repo.filmleriYukle()
        }
    }
    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            filmlerListesi.value=repo.ara(aramaKelimesi)
            filmleriYukle()
        }
    }


}