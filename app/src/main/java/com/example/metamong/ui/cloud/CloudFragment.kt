package com.example.metamong.ui.cloud

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.metamong.databinding.FragmentCloudBinding
import com.example.metamong.model.ViewpagerData
import com.example.metamong.model.ViewpagerRecyclerData
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

        loadData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadData() {
        val itemList = mutableListOf(
            ViewpagerData(
                "d", mutableListOf(
                    ViewpagerRecyclerData("dd"), ViewpagerRecyclerData("dd"),
                    ViewpagerRecyclerData("dd"), ViewpagerRecyclerData("dd")
                )
            ),
            ViewpagerData(
                "sd", mutableListOf(
                    ViewpagerRecyclerData("sddd"), ViewpagerRecyclerData("dd"),
                    ViewpagerRecyclerData("dd"), ViewpagerRecyclerData("dd")
                )
            )
        )
        binding.viewpagerCloud.adapter = Adapter(requireContext(), itemList)
        binding.viewpagerCloud.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        binding.viewpagerCloud.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("ViewPagerFragment", "Page${position + 1}")
            }

        })
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


//        val viewpagerAdapter = context?.let { Adapter(requireContext(),le) }
//        viewpagerAdapter?.letterList = loadData()
//
//        binding.viewpagerCloud.adapter = viewpagerAdapter
//        binding.viewpagerCloud.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        Log.d("ViewPagerFragment","Page${viewpagerAdapter?.letterList}")
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


