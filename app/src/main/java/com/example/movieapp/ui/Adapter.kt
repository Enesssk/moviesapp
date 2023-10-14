package com.example.movieapp.ui


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.data.model.Filmler
import com.example.movieapp.databinding.CardtasarimBinding


class Adapter (var mContext : Context, var filmlerListesi : List<Filmler> ) : RecyclerView.Adapter<Adapter.CardTasarımTutucu>() {

    inner class CardTasarımTutucu(var tasarim: CardtasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarımTutucu {
        val binding = CardtasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarımTutucu((binding))
    }


    override fun onBindViewHolder(holder: CardTasarımTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim

        t.filmImageView.setImageResource(
            mContext.resources.getIdentifier(film.resim, "drawable", mContext.packageName))

        t.fiyatTextView.text="${film.fiyat} $"
        t.filmNameText.text=film.name


        t.filmImageView.setOnClickListener {
            val action=MainFragmentDirections.actionMainFragmentToDetailsFragment(film)
            Navigation.findNavController(it).navigate(action)
        }
        t.filmNameText.setOnClickListener {
            val action=MainFragmentDirections.actionMainFragmentToSettingsFragment(film)
            Navigation.findNavController(it).navigate(action)
        }


    }


    override fun getItemCount(): Int {
        return filmlerListesi.size
    }


}