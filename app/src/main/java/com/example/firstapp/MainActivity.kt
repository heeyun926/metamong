package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup1.setOnCheckedChangeListener {group, checkId ->
            when(checkId){
            R.id.pencilSelect -> Log.d("RadioButton","다음 버튼을 클릭해주세요")
            R.id.talkSelect -> Log.d("RadioButton","다음 버튼을 클릭해주세요")
            }

        }

    }

}