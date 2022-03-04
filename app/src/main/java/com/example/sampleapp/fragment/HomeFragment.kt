package com.example.sampleapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.Adapter
import com.example.sampleapp.R
import com.example.sampleapp.data.model
import com.example.sampleapp.data.modeldao
import com.example.sampleapp.data.modeldatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    lateinit var modedao:modeldao

    private var adapter: Adapter?=null

    lateinit var data:List<model>
    private var rv: RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modedao=modeldatabase.getDatabase(requireContext())!!.modelDao()
        data= emptyList()



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv?.adapter=this.adapter
        add.setOnClickListener {
            addrandom()
        }
    }

    private fun getlist() {

        CoroutineScope(Dispatchers.IO).launch {
            data=modedao.getallitem()
        }
        adapter?.setdata(data)
    }

    fun addrandom(){
        val r=(0..100).random()
        val m= model(0,r)
        CoroutineScope(Dispatchers.IO).launch {
            modedao.insert(m)
        }
        getlist()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view=inflater.inflate(R.layout.fragment_home, container, false)
        rv=view.findViewById(R.id.rvPostsLis)
        adapter= Adapter(requireContext())
        rv?.layoutManager= LinearLayoutManager(requireContext())
        return view
    }


}