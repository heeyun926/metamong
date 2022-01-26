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
    var context: Context
) : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {
    var models = mutableListOf<ViewpagerData>()
    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding = ItemViewpagerCloudBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        val item = models[position]
        holder.bind(item)

    }



    inner class AdapterViewHolder(val binding: ItemViewpagerCloudBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val list = mutableListOf<ViewpagerData>()


        fun bind(data: ViewpagerData) {
            binding.title.text = data.text
            val adapter = ViewpagerRecyclerAdapter()
            adapter.letter = list.view
            binding.recyclerView.adapter = adapter

        }
    }
}