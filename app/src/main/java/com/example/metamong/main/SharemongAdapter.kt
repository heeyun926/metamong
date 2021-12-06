package com.example.metamong.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerSharemongBinding

class SharemongAdapter(val context:Context): RecyclerView.Adapter<SharemongAdapter.Holder>(){
    var sharemong = mutableListOf<SharemongData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SharemongAdapter.Holder {
        val binding = ItemRecyclerSharemongBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: SharemongAdapter.Holder, position: Int) {
        val sharemongdata = sharemong[position]
        holder.setSharemongs(sharemongdata)
    }

    override fun getItemCount(): Int = sharemong.size

    inner class Holder(val binding:ItemRecyclerSharemongBinding): RecyclerView.ViewHolder(binding.root){
        fun setSharemongs(data: SharemongData){
            binding.mainSharemongCharacter.setImageResource(data.character)
            binding.mainSharemongBG.setImageResource(data.background)
            binding.mainSharemongTextBg.setImageResource(data.textbackground)
            binding.sharemongTitle.text = data.title
            binding.sharemongScript.text = data.script
        }
    }

}

