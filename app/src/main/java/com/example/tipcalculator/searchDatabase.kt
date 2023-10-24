package com.example.tipcalculator

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [search::class],
    version = 1
)
abstract class searchDatabase : RoomDatabase(){
    companion object{
        private var INSTANCE: searchDatabase?=null;
        fun getInstance(context: Context): searchDatabase?{
            if(INSTANCE==null){
                synchronized(searchDatabase::class.java){
                    INSTANCE= Room.databaseBuilder(
                        context,
                        searchDatabase::class.java,
                        "database"
                    ).build()
                }
            }
            return INSTANCE;
        }
    }
    abstract fun searchDao(): searchDao
}
