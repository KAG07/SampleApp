package com.example.sampleapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sampleapp.R
import com.example.sampleapp.viewmodel.galleryviewmodel


class GalleryFragment : Fragment() {
    private lateinit var viewmodel:galleryviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewmodel=ViewModelProvider(this).get(galleryviewmodel::class.java)
       val view= inflater.inflate(R.layout.fragment_gallery, container, false)
        var txtv=view.findViewById<TextView>(R.id.txtv)
        viewmodel.text.observe(viewLifecycleOwner, Observer {
            txtv.text=it
        })
        return view
    }


}