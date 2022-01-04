package com.example.metamong.fragment.mypage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.navArgs
import com.example.metamong.R
import com.example.metamong.ResultDatailActivity
import com.example.metamong.databinding.ActivityHomeSubBinding
import com.example.metamong.databinding.ActivityMongsAddBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MongsAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMongsAddBinding
    private val memoViewModel: MemoViewModel by viewModels {
        MemoViewModelFactory((application as MemoApplication).repository)
    }

    private val newMonsActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMongsAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = MongsAdapter()

        memoViewModel.allMemos.observe(this) { memos ->
            // Update the cached copy of the words in the adapter.
            memos.let { adapter.submitList(it)
            Log.d("memo","activate")}}

            binding.MongsSaveBtn.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding.editTextTitle.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }else{
                val memo = binding.editTextTitle.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, memo)
                setResult(Activity.RESULT_OK,replyIntent)
                Log.d("memo","memoInsert?")
            }
            finish()
        }


    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == newMonsActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            data?.getStringExtra(EXTRA_REPLY)?.let { reply ->
//                val memo = Memo(reply)
//                Log.d("memo","memoInsert")
//                memoViewModel.insert(memo)
//
//            }
//        } else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }

}