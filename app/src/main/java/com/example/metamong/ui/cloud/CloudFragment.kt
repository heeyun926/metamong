package com.example.metamong.ui.cloud

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.metamong.R
import com.example.metamong.databinding.FragmentCloudBinding
import com.example.metamong.model.LookTalkData
import com.example.metamong.model.StudyData
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

        binding.recyclerStudy.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerStudy.adapter = StudyAdapter()

        val study: MutableList<StudyData> = loadData2()
        val studyAdapter = StudyAdapter()
        studyAdapter.studyList = study
        binding.recyclerStudy.adapter = studyAdapter
    }

    private fun loadData2(): MutableList<StudyData> {
        val studyList = mutableListOf<StudyData>()
        with(studyList) {
            add(
                StudyData(
                    R.drawable.bg_cloudstudy_bg,
                    R.drawable.study_1,
                    "App Study"
                )
            )
            add(
                StudyData(
                    R.drawable.bg_cloudstudy_bg,
                    R.drawable.study_1,
                    "App Study"
                )
            )
            add(
                StudyData(
                    R.drawable.bg_cloudstudy_bg,
                    R.drawable.study_1,
                    "App Study"
                )
            )
        }
        return studyList
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}




