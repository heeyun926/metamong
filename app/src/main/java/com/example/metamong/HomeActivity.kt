package com.example.metamong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.setOnItemSelectedListener
import com.example.metamong.databinding.ActivityHomeBinding
import com.example.metamong.fragment.CloudFragment
import com.example.metamong.fragment.HomeFragment
import com.example.metamong.fragment.MissionFragment
import com.example.metamong.fragment.MypageFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    private val homeFragment by lazy { HomeFragment() }
    private val cloudFragment by lazy { CloudFragment() }
    private val missionFragment by lazy { MissionFragment() }
    private val mypageFragment by lazy { MypageFragment() }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initNavigationBar()


    }
    private fun initNavigationBar(){
        binding.mainhome.run{
            //setOnItemSelectedListener{
                //when(it.itemId)

            //}
        }
    }
}