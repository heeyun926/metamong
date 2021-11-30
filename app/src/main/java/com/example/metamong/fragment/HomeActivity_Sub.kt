package com.example.metamong.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeSubBinding

class HomeActivity_Sub : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeSubBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // home_sub에 inflate binding
        mBinding = ActivityHomeSubBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

       //Navigation Fragment 생성
        val navigationFragment : NavHostFragment? =supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        //Navigation Controller 생성
        val navController = navigationFragment?.navController
        //Bottom_nav menu, Navigation Controller add
        navController?.let { NavigationUI.setupWithNavController(mBinding.bottomNav, it) }
    }
}

