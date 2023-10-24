package com.example.tipcalculator

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class search(
    val url: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
