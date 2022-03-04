package com.example.sampleapp.fragment

import android.os.Bundle
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


class HomeFragment : Fragment() {


    private lateinit var viewmodel:homeviewmodel
    private var adapter: Adapter?=null

    lateinit var data:List<Model>
    private var rv: RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data= emptyList()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        adapter= Adapter(requireContext())
        rv?.layoutManager= LinearLayoutManager(requireContext())
        rv?.adapter=this.adapter
        viewmodel=ViewModelProvider(this).get(homeviewmodel::class.java)
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
        rv=view.findViewById(R.id.rvPostsLis)
        return view
    }


}