package com.example.metamong.fragment.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerMongsmemoBinding

import java.util.zip.Inflater

class MongsAdapter() : RecyclerView.Adapter<MongsAdapter.Holder>() {
    val mongsMemo = mutableListOf<MongsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerMongsmemoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val mongsData = mongsMemo[position]
        holder.setMongs(mongsData)
    }

    override fun getItemCount() = mongsMemo.size

    class Holder (val binding:ItemRecyclerMongsmemoBinding): RecyclerView.ViewHolder(binding.root){
        fun setMongs(data : MongsData) {
            with(binding){
                mongsBg.setImageResource(data.bg)
                mongsContentBg.setImageResource(data.contentBg)
                mongsimageBg.setImageResource(data.imgBg)
                mongsTitle.text = data.title
                mongsContent.text = data.content
            }
        }
    }

}