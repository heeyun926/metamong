package com.example.metamong.ui.cloud

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerViewpagerBinding
import com.example.metamong.model.ViewpagerData
import com.example.metamong.model.ViewpagerRecyclerData

class ViewpagerRecyclerAdapter(context: Context, val letterItem: MutableList<ViewpagerRecyclerData>) : RecyclerView.Adapter<ViewpagerRecyclerAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = letterItem[position]
        holder.setLetter(data)
    }

    override fun getItemCount(): Int = letterItem.size

    inner class Holder(val binding:ItemRecyclerViewpagerBinding):RecyclerView.ViewHolder(binding.root){
        fun setLetter(data: ViewpagerRecyclerData){
            binding.contentTitle.text = data.text
        }
    }
}