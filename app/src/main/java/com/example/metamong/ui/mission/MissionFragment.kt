package com.example.metamong.ui.mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMissionBinding
import com.example.metamong.model.MissionIngData

class MissionFragment : Fragment() {
    private var binding : FragmentMissionBinding? = null
    val progressint = 50
    private fun loadData(): MutableList<MissionIngData>{
        val list = mutableListOf<MissionIngData>()
        with(list){
            add(MissionIngData(R.drawable.ic_mission_little_ing, "사용자인터뷰", progressint))
        }
        return list
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentMissionBinding.inflate(inflater,container,false)
        binding = mBinding
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : MutableList<MissionIngData> = loadData()
        val missionIngAdapter = context?.let{ MissionIngAdapter() }
        missionIngAdapter?.missioning = data
        binding?.missionIngRecyclerView?.adapter = missionIngAdapter
    }

    override fun onDestroyView() {
        binding =null
        super.onDestroyView()
    }
}