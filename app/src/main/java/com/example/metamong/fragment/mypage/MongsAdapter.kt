package com.example.metamong.fragment.mypage


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.databinding.ItemRecyclerMongsmemoBinding
import com.example.metamong.fragment.mypage.DB.Memo
import com.example.metamong.fragment.mypage.DB.MemoViewModel

class MongsAdapter(private val memoViewModel: MemoViewModel) : RecyclerView.Adapter<MongsAdapter.MemoViewHolder>() {
    private var memoList = emptyList<Memo>()

    class MemoViewHolder(private val binding: ItemRecyclerMongsmemoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        lateinit var memo: Memo
        lateinit var memoViewModel: MemoViewModel

        private val memoItemView: TextView = itemView.findViewById(R.id.mongsContent)

        fun bind(currentMemo: Memo, memoViewModel: MemoViewModel) {
            binding. memo = currentMemo
            this.memoViewModel = memoViewModel
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val binding =
            ItemRecyclerMongsmemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoList[position], memoViewModel)
    }

    override fun getItemCount(): Int {
        return memoList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(memo: List<Memo>) {
        memoList = memo
        notifyDataSetChanged()
    }
}
/**
 * class MemosComparator : DiffUtil.ItemCallback<Memo>() {
override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
return oldItem === newItem
}

override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
return oldItem.memo == newItem.memo}
}
 **/
