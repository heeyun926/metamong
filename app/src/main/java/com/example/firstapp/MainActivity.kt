package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext1.isEnabled = false
        binding.radioGroup1.setOnCheckedChangeListener {group, checkId ->
            when(checkId){
            R.id.pencilSelect ->
                binding.btnNext1.isEnabled = true
            R.id.talkSelect ->
                binding.btnNext1.isEnabled = true


            }
        }


    }

}