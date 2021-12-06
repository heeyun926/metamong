package com.example.metamong.fragment.mission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerMissionIngBinding
import com.example.metamong.databinding.ItemRecyclerSharemongBinding
import com.example.metamong.fragment.home.SharemongAdapter
import com.example.metamong.fragment.home.SharemongData

class MissionIngAdapter : RecyclerView.Adapter<MissionIngAdapter.Holder>() {
    var missioning = mutableListOf<MissionIngData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerMissionIngBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val sharemongdata = missioning[position]
        holder.setSharemongs(sharemongdata)
    }

    override fun getItemCount(): Int = missioning.size

    inner class Holder(val binding: ItemRecyclerMissionIngBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setSharemongs(data: MissionIngData) {
            binding.missionBackground.setImageResource(data.img)
            binding.missionTitle.text = data.title
            binding.missionProgressBar.progress = data.progress
        }
    }
}