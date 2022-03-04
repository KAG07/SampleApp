package com.example.sampleapp.data


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface modeldao {

    @Insert
    suspend fun insert(model1: model)

    @Query("SELECT *FROM yes_thats_me" )
    suspend fun getallitem():List<model>
}