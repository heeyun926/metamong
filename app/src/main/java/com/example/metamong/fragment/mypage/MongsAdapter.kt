package com.example.metamong.fragment.mypage


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.databinding.ItemRecyclerMongsmemoBinding

class MongsAdapter: ListAdapter<Memo, MongsAdapter.MemoViewHolder>(MemosComparator()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.memoContent)
    }
    class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val memoItemView: TextView = itemView.findViewById(R.id.mongsContent)

        fun bind(text: String?){
            memoItemView.text = text
        }
        companion object {
            fun create(parent: ViewGroup):MemoViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycler_mongsmemo, parent, false)
                return MemoViewHolder(view)
            }
        }
    }
    class MemosComparator : DiffUtil.ItemCallback<Memo>() {
        override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
            return oldItem.memoContent == newItem.memoContent
        }
    }
}