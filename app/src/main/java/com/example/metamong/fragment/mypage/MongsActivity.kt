package com.example.metamong.fragment.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeSubBinding
import com.example.metamong.databinding.ActivityMongsBinding

class MongsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMongsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMongsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMongs)
        val adapter = MongsAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnAddMongs.setOnClickListener{
            val intent = Intent(this, MongsAddActivity::class.java)
            startActivity(intent)
        }
    }

}