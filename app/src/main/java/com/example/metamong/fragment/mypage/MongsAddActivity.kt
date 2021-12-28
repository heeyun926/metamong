package com.example.metamong.fragment.mypage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeSubBinding
import com.example.metamong.databinding.ActivityMongsAddBinding

class MongsAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMongsAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMongsAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.MongsSaveBtn.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding.editTextTitle.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }else{
                val memo = binding.editTextTitle.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, memo)
                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}