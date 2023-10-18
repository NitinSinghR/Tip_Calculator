package com.example.tipcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.NumberFormat

class FirstFragment: Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calculate = view.findViewById<Button>(R.id.calculate_button)
            calculate.setOnClickListener { calculateTip() }
    }
    private fun calculateTip(){
        var serviceCost = view?.findViewById<EditText>(R.id.CostService)?.text.toString()
        val cost = serviceCost.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        val tipPercentage = when (view?.findViewById<RadioGroup>(R.id.tip_options)?.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost

        displayTip(tip)
    }

    private fun displayTip (tip:Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        view?.findViewById<TextView>(R.id.tip_result)?.text  = "Tip Amount : $formattedTip"
    }
}