package com.example.tipcalculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchValue = view.findViewById<EditText>(R.id.searchText)
        val searchButton = view.findViewById<Button>(R.id.button4)
        searchButton.setOnClickListener{
            val url = searchValue.text.toString()
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q= $url"))
            startActivity(urlIntent)
        }
    }
}