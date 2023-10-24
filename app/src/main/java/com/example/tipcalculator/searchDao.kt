package com.example.tipcalculator

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert


@Dao
interface searchDao {

    @Query("SELECT * FROM search")
    fun getAllItems(): MutableList<search>
    @Upsert
    suspend fun insertSearch(search: search)

    @Delete
    fun deleteSearch(search: search)

    @Query("SELECT * FROM search")
    fun getAllItemsLiveData(): LiveData<List<search?>?>?

}