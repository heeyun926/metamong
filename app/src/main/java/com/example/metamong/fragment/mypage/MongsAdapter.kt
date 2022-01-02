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
import com.example.metamong.fragment.mypage.DB.Memo
import com.example.metamong.fragment.mypage.DB.MemoViewModel

class MongsAdapter(memoViewModel: MemoViewModel) : ListAdapter<Memo, MongsAdapter.MemoViewHolder>(MemosComparator()){
    private var memoList = emptyList<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(parent)

    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.memo)
    }
    class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val memoItemView: TextView = itemView.findViewById(R.id.mongsContent)

        fun bind(text: String?){
            memoItemView.text = text
        }

    }
    class MemosComparator : DiffUtil.ItemCallback<Memo>() {
        override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
            return oldItem.memo == newItem.memo
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(memo : List<Memo>){
        memoList = memo
        notifyDataSetChanged()
    }
}