package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent = Intent(this, SecondActivity::class.java)
        binding.button3.setOnClickListener{
            intent.putExtra("name",binding.nameText.text.toString())
            startActivity(intent)
        }
    }
}