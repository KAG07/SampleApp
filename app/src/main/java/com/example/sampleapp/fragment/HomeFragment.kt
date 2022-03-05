package com.example.sampleapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.Adapter
import com.example.sampleapp.data.Model
import com.example.sampleapp.viewmodel.homeviewmodel
import com.example.sampleapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList


class HomeFragment : Fragment() {


    private lateinit var viewmodel:homeviewmodel

    private var adapter: Adapter?=null

    lateinit var data:ArrayList<Model>

    private var rv: RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data= ArrayList()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv=view.findViewById(R.id.rvPostsLis)
        viewmodel=ViewModelProvider(this).get(homeviewmodel::class.java)
        data.clear()
        data=viewmodel.addrandom()
        Log.d("Home",data.size.toString())
        adapter= Adapter(requireContext())
        rv?.layoutManager= LinearLayoutManager(requireContext())


        rv?.adapter=this.adapter
        add.setOnClickListener {
          data= viewmodel.addrandom()
            setlist()
        }
    }

    fun setlist() {
        adapter?.setdata(data)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view=inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

}