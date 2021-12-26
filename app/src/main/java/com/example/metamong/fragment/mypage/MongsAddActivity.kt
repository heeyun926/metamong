package com.example.metamong.fragment.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        }
    }

}