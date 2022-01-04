package com.example.metamong.fragment.mypage


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ItemRecyclerMongsmemoBinding

class MongsAdapter(private val memoViewModel: MemoViewModel) : ListAdapter<Memo, MongsAdapter.MemoViewHolder>(MemosComparator()) {
    private var memoList = emptyList<Memo>()

    class MemoViewHolder(val binding: ItemRecyclerMongsmemoBinding) :
        RecyclerView.ViewHolder(binding.root){
        lateinit var memo : Memo
        lateinit var memoViewModel: MemoViewModel
        fun bind(currentMemo : Memo, memoViewModel: MemoViewModel){
            binding.memo = currentMemo
            this.memoViewModel = memoViewModel
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val binding =
            ItemRecyclerMongsmemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoList[position],memoViewModel)
        val Memo = memoList[position]
        holder.binding.mongsContent.text = Memo.memoContent
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(memo: List<Memo>) {
        memoList = memo
        notifyDataSetChanged()
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


