package com.example.sampleapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [model::class],
    version = 1
)
abstract class modeldatabase:RoomDatabase() {

    abstract fun modelDao(): modeldao

    companion object {

        @Volatile
        private var INSTANCE: modeldatabase? = null

        fun getDatabase(context: Context): modeldatabase? {
            if (INSTANCE == null) {
                synchronized(modeldatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            modeldatabase::class.java, "message_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}