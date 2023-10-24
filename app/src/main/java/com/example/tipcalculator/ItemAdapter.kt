package com.example.tipcalculator

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(itemList: MutableList<search>, itemDao: searchDao) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val itemList: MutableList<search>
    private val itemDao: searchDao

    init {
        this.itemList = itemList
        this.itemDao = itemDao
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: search = itemList[position]
        holder.textView.text = item.url

        holder.deleteButton.setOnClickListener { v ->
            Log.i("MYTAG","Delete")
            try{
                itemDao.deleteSearch(item)
            }catch (e: Exception){
                Log.i("MYTAG","Haven't deleted yet ${e.message.toString()}")
            }
//            itemList.remove(item)
//            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var deleteButton: Button

        init {
            textView = itemView.findViewById(R.id.itemName)
            deleteButton = itemView.findViewById(R.id.deleteButton)
        }
    }
}
