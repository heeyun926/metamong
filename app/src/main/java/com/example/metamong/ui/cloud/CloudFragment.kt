package com.example.metamong.ui.cloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets.add
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.metamong.R
import com.example.metamong.databinding.FragmentCloudBinding
import com.example.metamong.model.ViewpagerData
import com.example.metamong.ui.home.SharemongAdapter

class CloudFragment : Fragment() {
    private var _binding: FragmentCloudBinding? = null
    private val binding get() = _binding!!
    private val viewPager = binding.viewpagerCloud
    var models: MutableList<String> = mutableListOf()
    var adapter = context?.let { Adapter(models, it) }


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

        models.add("AAAAAA")
        models.add("BBBBBB")
        models.add("CCCCCC")
        models.add("DDDDDD")

        viewPager.adapter = adapter
        viewPager.setPadding(30, 0, 30, 0)
        childFragmentManager

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}