package com.example.metamong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.metamong.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext1.isEnabled = false


        binding.radioGroup1.setOnCheckedChangeListener {group, checkId ->
            when(checkId){
            R.id.pencilSelect -> {
                binding.btnNext1.isEnabled = true
                binding.pencil.setImageResource(R.drawable.pencil)
                binding.talk.setImageResource(R.drawable.noselect_talk)
            }

            R.id.talkSelect ->{
                binding.btnNext1.isEnabled = true
                binding.pencil.setImageResource(R.drawable.noselect_pencil)
                binding.talk.setImageResource(R.drawable.talk)
            }
            }
        }

        binding.btnNext1.setOnClickListener{
            val intent = Intent (this,ResultActivity::class.java)
            startActivity(intent)
        }


    }

}