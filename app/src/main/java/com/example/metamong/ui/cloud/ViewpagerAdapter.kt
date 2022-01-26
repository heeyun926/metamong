package com.example.metamong.ui.cloud

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.databinding.ItemRecyclerSharemongBinding
import com.example.metamong.databinding.ItemViewpagerCloudBinding
import com.example.metamong.fragment.home.SharemongData
import com.example.metamong.model.ViewpagerData

class Adapter(
    var context: Context,
    val letterList : MutableList<ViewpagerData>
) : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    override fun getItemCount(): Int = letterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding = ItemViewpagerCloudBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        val item = letterList[position]
        holder.bind(item)

    }



    inner class AdapterViewHolder(val binding: ItemViewpagerCloudBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ViewpagerData) {
            binding.title.text = data.text
            binding.recyclerView.adapter = ViewpagerRecyclerAdapter(context, data.viewpagerList)
//            val adapter = ViewpagerRecyclerAdapter()
//            adapter.letter = list.view
//            binding.recyclerView.adapter = adapter

        }
    }
}