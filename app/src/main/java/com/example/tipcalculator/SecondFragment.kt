package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchValue = view.findViewById<EditText>(R.id.searchText)
        val searchButton = view.findViewById<Button>(R.id.button4)
        searchButton.setOnClickListener{
            val url = searchValue.text.toString()
            var database=searchDatabase.getInstance(requireContext())
            var searchDao=database?.searchDao()
            val search = search(url)
            GlobalScope.launch {
                try {
                    searchDao?.insertSearch(search);
                    Log.i("MYTAG", "SEARCH IS ADDED")
                }
                catch(e: Exception){
                    Log.e("MYTAG",e.message.toString());
                }

            }
//            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q= $url"))
//            startActivity(urlIntent)
        }
    }
}