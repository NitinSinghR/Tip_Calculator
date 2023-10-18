package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivitySecondBinding

class SecondActivity:AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,firstFragment)
            commit()
        }

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val name = bundle?.get("name").toString()

        binding.nameValue.text = "Hi, $name"

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