package com.example.metamong.ui.cloud

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerViewpagerBinding
import com.example.metamong.model.ViewpagerData

class ViewpagerRecyclerAdapter : RecyclerView.Adapter<ViewpagerRecyclerAdapter.Holder>(){
    var letter = mutableListOf<ViewpagerData>()

    fun letter(): MutableList<ViewpagerData> {
        val letterList = mutableListOf<ViewpagerData>()
        with(letterList){
            add(
                ViewpagerData("UX Writing의 5가지 방법")
            )
            add(
                ViewpagerData("로그인 UI를 지루하지 않게 디자인하기")
            )
            add(
                ViewpagerData("로그인 UI를 지루하지 않게 디자인하기")
            )
            add(
                ViewpagerData("로그인 UI를 지루하지 않게 디자인하기")
            )}
        return letterList
    }
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