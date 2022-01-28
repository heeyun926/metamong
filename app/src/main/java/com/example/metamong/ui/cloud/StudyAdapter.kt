package com.example.metamong.ui.cloud

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerStudyBinding
import com.example.metamong.model.StudyData

class StudyAdapter : RecyclerView.Adapter<StudyAdapter.Holder>() {
    var studyList = mutableListOf<StudyData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyAdapter.Holder {
        val binding = ItemRecyclerStudyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val studyData = studyList[position]
        holder.bind(studyData)
    }


    override fun getItemCount(): Int = studyList.size

    inner class Holder(val binding: ItemRecyclerStudyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: StudyData){
            with(binding){
                bg.setImageResource(data.bg)
                contentImg.setImageResource(data.contentImg)
                text.text = data.text
            }
        }
    }
}