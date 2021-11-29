package com.example.metamong.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeBinding
import com.example.metamong.databinding.ActivityHomeSubBinding

class HomeActivity_Sub : AppCompatActivity() {
    private lateinit var binding: ActivityHomeSubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeSubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList =
            listOf(HomeFragment(), CloudFragment(), MissionFragment(), MypageFragment())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter


        val navHostFragment = binding.bottomNav as NavHostFragment

        binding.bottomNav.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.homeFragment -> {
                        val homeFragment = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, homeFragment).commit()
                    }

                    else -> {}
                }
                true
            }
            selectedItemId = R.id.homeFragment
        }
    }
}

class FragmentAdapter(homeSubBinding: HomeActivity_Sub):
        FragmentStateAdapter(homeSubBinding){
    var fragmentList = listOf<Fragment>()
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}