package com.example.metamong.ui.mypage.memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerMongsmemoBinding
import com.example.metamong.model.Memo

class MemoListAdapter (private val onItemClicked: (Memo) -> Unit) :
    ListAdapter<Memo, MemoListAdapter.ItemViewHolder>(DiffCallback) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(
                ItemRecyclerMongsmemoBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    )
                )
            )
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val current = getItem(position)
            holder.itemView.setOnClickListener {
                onItemClicked(current)
            }
            holder.bind(current)
        }

        class ItemViewHolder(private var binding: ItemRecyclerMongsmemoBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(memo: Memo) {
                binding.mongsContent.text = memo.memoContent
                binding.mongsTitle.text = memo.memoTitle
            }
        }

        companion object {
            private val DiffCallback = object : DiffUtil.ItemCallback<Memo>() {
                override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                    return oldItem === newItem
                }

                override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
                    return oldItem.memoTitle == newItem.memoTitle
                }
            }
        }


}