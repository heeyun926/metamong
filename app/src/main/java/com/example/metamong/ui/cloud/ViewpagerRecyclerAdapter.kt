package com.example.metamong.ui.cloud

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerViewpagerBinding
import com.example.metamong.model.ViewpagerData

class ViewpagerRecyclerAdapter : RecyclerView.Adapter<ViewpagerRecyclerAdapter.Holder>(){
    var letter = mutableListOf<ViewpagerData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val letterData = letter[position]
        holder.setLetter(letterData)
    }

    override fun getItemCount(): Int = letter.size

    inner class Holder(val binding:ItemRecyclerViewpagerBinding):RecyclerView.ViewHolder(binding.root){
        fun setLetter(data: ViewpagerData){
            binding.contentTitle.text = data.text
        }
    }
}