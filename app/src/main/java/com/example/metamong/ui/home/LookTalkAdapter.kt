package com.example.metamong.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerLooktalkBinding
import com.example.metamong.model.LookTalkData

class LookTalkAdapter(): RecyclerView.Adapter<LookTalkAdapter.Holder>(){
    var lookTalkList = mutableListOf<LookTalkData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LookTalkAdapter.Holder {
        val binding = ItemRecyclerLooktalkBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: LookTalkAdapter.Holder, position: Int) {
        val lookTalkData = lookTalkList[position]
        holder.bind(lookTalkData)
    }

    override fun getItemCount(): Int = lookTalkList.size

    inner class Holder(val binding: ItemRecyclerLooktalkBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: LookTalkData){
            with(binding){
                looktalkbg.setImageResource(data.looktalkbg)
                lookTalkMainImage.setImageResource(data.lookTalkMainImage)
                dDayBg.setImageResource(data.dDayBg)
                lookTitle.text = data.lookTitle
                lookContent.text = data.lookContent
                dDayText.text = data.dDayText
            }
        }
    }

}