package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchValue = view.findViewById<EditText>(R.id.searchText)
        val searchButton = view.findViewById<Button>(R.id.button4)
        val database=searchDatabase.getInstance(requireContext())
        val searchDao=database?.searchDao()
        var items: MutableList<search> = mutableListOf()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        GlobalScope.launch{
            try{
                Log.i("MYTAG","Inside")
                items = searchDao!!.getAllItems()
                val itemAdapter = searchDao?.let { ItemAdapter(items, it) }
                recyclerView.adapter = itemAdapter
            }catch (e: Exception){
                Log.e("MYTAG",e.message.toString())
            }
        }

//        searchDao.getAllItemsLiveData().observe(viewLifecycleOwner, object : Observer<List<search?>?> {
//            override fun onChanged(items: List<search?>?) {
//                itemAdapter.setItemList(items)
//            }
//        })
        searchButton.setOnClickListener{
            val url = searchValue.text.toString()
            val search = search(url)
            GlobalScope.launch {
                try {
                    searchDao?.insertSearch(search)
                    Log.i("MYTAG", "SEARCH IS ADDED")
                }
                catch(e: Exception){
                    Log.e("MYTAG",e.message.toString())
                }

            }
//            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q= $url"))
//            startActivity(urlIntent)
        }
    }
}