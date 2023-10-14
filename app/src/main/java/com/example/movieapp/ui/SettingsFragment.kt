package com.example.movieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.model.Filmler
import com.example.movieapp.databinding.FragmentSettingsBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    lateinit var listem:List<Filmler>
    val filmList = ArrayList<Filmler>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSettingsBinding.inflate(inflater,container,false)

        val bundle : SettingsFragmentArgs by navArgs()
        val film=bundle.filmDetay

        filmList.add(film)
        listem=filmList





        binding.recyclerview.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        var adapter=SettingsAdapter(requireContext(),listem)
        binding.recyclerview.adapter=adapter
        adapter.notifyDataSetChanged()





        return binding.root
    }


}