package com.example.metamong.NotWork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.metamong.R

import com.example.metamong.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //네비게이션 담는 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment
        //네비게이션 컨트롤러
        val navController = navHostFragment.navController
        //바텀 네비게이션 뷰와 네비게이션 묶기
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
    }



    /**
        //setFragment(homeFragment,HomeFragment())
        mainhome.setOnItemSelectedListener{ item->
            when(item.itemId){

            }

        }

        //init Fragment
        chageFragment(binding.mainhome)
    }
    private fun changeFragment((menuItemId: Int) {
        val targetFragment = getFragment(menuItemId)
        supportFragmentManager.beginTransaction() .replace(R.id.container, targetFragment)
            .commitAllowingStateLoss() }
    private fun getFragment(menuItemId: Int): Fragment {
        val title = when (menuItemId) {
            R.id.cloudFragment -> "cloud"
            R.id.missionFragment -> "mission"
            R.id.mypageFragment -> "mypage"
            else -> throw IllegalArgumentException("not found menu item id") }
        return HomeFragment.newInstance(title) }
**/

}