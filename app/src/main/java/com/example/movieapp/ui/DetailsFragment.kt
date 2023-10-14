package com.example.movieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs

import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailsBinding
import com.example.movieapp.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailsBinding.inflate(inflater,container,false)


       val bundle : DetailsFragmentArgs by navArgs()
        val film=bundle.film

        binding.movieImageView.setImageResource(
            resources.getIdentifier(film.resim,"drawable",requireContext().packageName)
        )
        binding.movieNameText.text=film.name
        binding.hourText.text=film.süre
        binding.genreText.text=film.tür
        binding.yearText.text=film.yıl.toString()
        binding.descriptionTextView.text=film.metin

        binding.addListButton.setOnClickListener {
            var gecis=DetailsFragmentDirections.actionDetailsFragmentToSettingsFragment(film)
            Navigation.findNavController(it).navigate(gecis)
        }

        binding.buyButton.setOnClickListener {
            Snackbar.make(it,"This movie has been purchased ✓",Snackbar.LENGTH_SHORT).
            setBackgroundTint(resources.getColor(R.color.white)).setTextColor(resources.getColor(R.color.purple_700)).show()
            binding.buyButton.visibility=View.INVISIBLE
        }

        return binding.root
    }


}