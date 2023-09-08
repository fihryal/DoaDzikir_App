package com.faqiy.doadzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.model.DoaDzikirItem


class DoaDzikirAdapter : RecyclerView.Adapter<DoaDzikirAdapter.DzikirViewHolder>() {

    private val listData = ArrayList<DoaDzikirItem>()
    fun setData(list: List<DoaDzikirItem>){
        listData.clear()
        listData.addAll(list)
    }

    // viewholder take responsibility for initializ item from layout
    // in this class we will describ our item view from layout
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemTitle = view.findViewById<TextView>(R.id.item_title)
        val itemArabic = view.findViewById<TextView>(R.id.item_arabic)
        val itemtraslate = view.findViewById<TextView>(R.id.item_traslate)
    }


    // onCreateViewHolder prevides layout to be used by viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_doa, parent, false)
    )


    // getItemCount is counting the size of data set will be display on rectangleView
    override fun getItemCount() = listData.size

    // onBindViewHolder distributed data in their position on item view
    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
    holder.apply {
        itemTitle.text = listData[position].title
        itemArabic.text = listData[position].arabic
        itemtraslate.text = listData[position].traslate
    }
    }
}