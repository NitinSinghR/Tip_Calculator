package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,firstFragment)
            commit()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment,firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.button2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment,secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

}