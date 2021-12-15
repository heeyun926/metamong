package com.example.metamong.fragment.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerMongsmemoBinding
import com.example.metamong.fragment.mypage.DB.Memo

class MongsAdapter(val context: MypageFragment, private val memos: List<Memo>) : RecyclerView.Adapter<MongsAdapter.Holder>() {
    var mongsMemo = mutableListOf<MongsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerMongsmemoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setMongs(memos[position])
    }

    override fun getItemCount() = memos.size

    class Holder (val binding:ItemRecyclerMongsmemoBinding): RecyclerView.ViewHolder(binding.root){
        fun setMongs(data : Memo) {
            with(binding){
                mongsBg.setImageResource(data.memoBg)
                mongsContentBg.setImageResource(data.memoContentBg)
                mongsimageBg.setImageResource(data.memoImgBg)
                mongsTitle.text = data.memoTitle
                mongsContent.text = data.memoContent
            }
        }
    }

}