package com.example.metamong.ui.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.metamong.databinding.ActivityResultDatailBinding
import com.example.metamong.model.ProfileData
import java.io.Serializable

class ResultDatailActivity : AppCompatActivity(), Serializable {
    private lateinit var datas : ProfileData
    private lateinit var binding : ActivityResultDatailBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultDatailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (intent.getSerializableExtra("data") != null) {
            datas = intent.getSerializableExtra("data") as ProfileData

            Glide.with(this).load(datas.image).into(binding.resultDatailImage)
            binding.resultDatailTitle.text = datas.name
            binding.resultDatailText.text = datas.tag
            binding.resultDetailScript.text = datas.script


        }
    }
}