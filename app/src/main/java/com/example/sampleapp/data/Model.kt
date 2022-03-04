package com.example.sampleapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "yes_thats_me")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val code: Long,
    @ColumnInfo(name = "logic")
    val order: Int
)
