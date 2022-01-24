package com.example.metamong.ui.cloud

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.metamong.R
import com.example.metamong.databinding.FragmentCloudBinding
import com.example.metamong.fragment.home.SharemongData
import com.example.metamong.model.LookTalkData
import com.example.metamong.model.ViewpagerData
import com.example.metamong.ui.home.SharemongAdapter

class CloudFragment : Fragment() {
    private var _binding: FragmentCloudBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentCloudBinding.inflate(inflater, container, false)
        _binding = mBinding


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun loadData() : MutableList<ViewpagerData> {
                val list = mutableListOf<ViewpagerData>()
                with(list) {
                    add(
                        ViewpagerData("Android?")
                    )
                    add(
                        ViewpagerData("Androidfdfd?")
                    )
                    add(
                        ViewpagerData("Adsdsdsd")
                    )
                }
            return list
        }

        val data: MutableList<ViewpagerData> = loadData()

        val viewpagerAdapter = context?.let { Adapter(requireContext()) }
        viewpagerAdapter?.models = data


        binding.viewpagerCloud.adapter = context?.let { Adapter(it) }
        binding.viewpagerCloud.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        Log.d("ViewPagerFragment","Page${loadData()}")
        binding.viewpagerCloud.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("ViewPagerFragment","Page${position+1}")
            }
        })
//        viewPager.setPadding(30, 0, 30, 0)


//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//            }
//        })

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}