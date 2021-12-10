package com.example.metamong.notworked.memodb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.*
import com.example.metamong.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemoBinding
    private lateinit var db: MemoDatabase
    var memoList = listOf<RoomMemo>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MemoDatabase.getInstance(this)!!
        binding.btnSave.setOnClickListener {
            //val memo = RoomMemo(null, binding.editMemo.text.toString())
            //insertMemo(memo)
        }
    }


    //1. Insert Data
    //2. Get Data
    //3. Delete Data
    //4. Set RecyclerView

    fun insertMemo(memo: RoomMemo) {
        //1. MainThread vs WorkerThread(Background Thread)


    }

    fun getAllMemos() {

    }

    fun deleteMemo() {

    }

    fun setRecyclerView() {

    }
}






