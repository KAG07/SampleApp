package com.example.sampleapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.data.Model
import com.example.sampleapp.data.modeldao
import com.example.sampleapp.data.modeldatabase
import kotlinx.coroutines.launch

class homeviewmodel(application: Application):AndroidViewModel(application) {
     var data= emptyList<Model>()
    lateinit var modedao: modeldao
    init {
        modedao= modeldatabase.getDatabase(application)!!.modelDao()

    }

    fun addrandom():List<Model>{
        val r=(0..100).random()
        val m= Model(0,r)
        viewModelScope.launch {
            modedao.insert(m)
        }
        viewModelScope.launch {
            data = modedao.getallitem()
        }
        return data
    }
}