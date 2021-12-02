package com.example.metamong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ActivityMainBinding
import com.example.metamong.databinding.ActivityMemoBinding
import com.example.metamong.databinding.ItemMetamongresultBinding
import com.example.metamong.databinding.ItemRecyclermemoBinding
import com.example.metamong.fragment.HomeFragment
import java.text.SimpleDateFormat

class MemoActivity : AppCompatActivity() {

    var DB_NAME ="sqlite.sql"
    var DB_VERSION = 1
    private lateinit var binding : ActivityMemoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val helper =SqliteHelper(this,DB_NAME,DB_VERSION)
        val adapter =MemoAdapter()

        //memo data select
        adapter.listData.addAll(helper.selectMemo())
        binding.recyclerMemo.adapter =adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)
        //memo insert
        binding.btnAdd.setOnClickListener {
            if (binding.editMemo.text.toString().isNotEmpty()) {
                val memo = Memo(null, binding.editMemo.text.toString(), System.currentTimeMillis())
                helper.insertMemo(memo)
                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()

                binding.editMemo.setText("")
            }
        }
        binding.btnSave.setOnClickListener{
            Intent(this, HomeActivity_Sub::class.java)
            finish()
        }
    }
}


class MemoAdapter: RecyclerView.Adapter<MemoAdapter.Holder>(){
    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclermemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData[position]
        holder.setMemo(memo)

    }

    override fun getItemCount(): Int =listData.size


    inner class Holder(val binding: ItemRecyclermemoBinding): RecyclerView.ViewHolder(binding.root){
        fun setMemo(data:Memo){
            binding.memoNo.text = "${data.no}"
            binding.memoContent.text = data.content

            val formats =SimpleDateFormat("MM.dd.hh")
            val datetiming = formats.format(data.datetime)
            binding.memoDatetime.text = datetiming
        }
    }
}
