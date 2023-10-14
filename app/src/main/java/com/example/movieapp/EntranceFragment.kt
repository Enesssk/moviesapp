package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentEntranceBinding
import com.example.movieapp.databinding.FragmentSettingsBinding

class EntranceFragment : Fragment() {

    private lateinit var binding: FragmentEntranceBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentEntranceBinding.inflate(inflater,container,false)

        binding.buttonMainScreen.setOnClickListener {
            findNavController().navigate(EntranceFragmentDirections.actionEntranceFragmentToMainFragment())
        }


        return binding.root
    }


}