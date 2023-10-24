package com.example.tipcalculator

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert

@Dao
interface searchDao {
    @Upsert
    suspend fun insertSearch(search: search)

    @Delete
    suspend fun deleteSearch(search: search)
}