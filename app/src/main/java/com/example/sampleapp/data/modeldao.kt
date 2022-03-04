package com.example.sampleapp.data


import androidx.room.*

@Dao
interface modeldao {

    @Insert
    suspend fun insert(model1: Model)

    @Query("SELECT *FROM yes_thats_me" )
    suspend fun getallitem():List<Model>
}