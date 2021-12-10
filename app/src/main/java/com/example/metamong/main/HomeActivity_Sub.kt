package com.example.metamong.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeSubBinding

class HomeActivity_Sub : AppCompatActivity() {
    private lateinit var binding: ActivityHomeSubBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // home_sub에 inflate binding
        binding = ActivityHomeSubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Navigation Fragment 생성
        val navigationFragment : NavHostFragment? =supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        //Navigation Controller 생성
        val navController = navigationFragment?.navController
        //Bottom_nav menu, Navigation Controller add
        navController?.let { NavigationUI.setupWithNavController(binding.bottomNav, it) }

    }
    var waitTime=0L
    override fun onBackPressed() {
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show()
        } else {
            finishAffinity()//app end
            //System.exit(0) //블루투스 연결 종료 및 현재 액티비티 종료
        }
    }
}

