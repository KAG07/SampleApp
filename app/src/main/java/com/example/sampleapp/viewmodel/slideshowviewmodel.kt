package com.example.sampleapp.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class slideshowviewmodel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Slideshow Fragment"
    }
    val text : LiveData<String> = _text
}