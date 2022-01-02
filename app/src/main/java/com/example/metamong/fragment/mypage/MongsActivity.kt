package com.example.metamong.fragment.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.R
import com.example.metamong.databinding.ActivityMongsBinding
import com.example.metamong.fragment.mypage.DB.Memo
import com.example.metamong.fragment.mypage.DB.MemoApplication
import com.example.metamong.fragment.mypage.DB.MemoViewModel
import com.example.metamong.fragment.mypage.DB.MemoViewModelFactory

class MongsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMongsBinding
    private val memoViewModel: MemoViewModel by viewModels {
        MemoViewModelFactory((application as MemoApplication).repository)
    }
    private val newMonsActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMongsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recyclerView = binding.recyclerMongs
        val adapter = MongsAdapter(memoViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnAddMongs.setOnClickListener {
            val intent = Intent(this, MongsAddActivity::class.java)
            startActivityForResult(intent, newMonsActivityRequestCode)
        }

        memoViewModel.allMemos.observe(this) { memos ->
            // Update the cached copy of the words in the adapter.
            memos.let { adapter.submitList(it) }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newMonsActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(MongsAddActivity.EXTRA_REPLY)?.let { reply ->
                val memo = Memo(reply)
                memoViewModel.insert(memo)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

}