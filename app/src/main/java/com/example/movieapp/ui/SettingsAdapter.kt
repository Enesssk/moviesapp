package com.example.movieapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.navArgument
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movieapp.data.model.Filmler
import com.example.movieapp.databinding.RecyclertasarimBinding

class SettingsAdapter (var mContext : Context, var filmListesi: List<Filmler>) : RecyclerView.Adapter<SettingsAdapter.RecyclerTutucu>(){

    inner class RecyclerTutucu (var tasarim : RecyclertasarimBinding) :ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerTutucu {
        var binding=RecyclertasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return RecyclerTutucu(binding)
    }


    override fun onBindViewHolder(holder: RecyclerTutucu, position: Int) {
       var film=filmListesi.get(position)
        var t=holder.tasarim

       t.nameText.text=film.name
        t.timeText.text=film.süre
        t.yearText.text=film.yıl.toString()
        t.turText.text=film.tür
        t.imageView.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName)
        )

    }

    override fun getItemCount(): Int {
        return filmListesi.size
    }

}