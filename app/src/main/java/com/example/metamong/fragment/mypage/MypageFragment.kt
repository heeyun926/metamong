package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.databinding.FragmentMypageBinding


class MypageFragment() : Fragment() {

    private val viewModel: MemoViewModel by activityViewModels {
        MemoViewModelFactory(
            (activity?.application as MemoApplication).repository
        )
    }
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnAddMongs2?.setOnClickListener {
            val intent = Intent(context, MongsAddActivity::class.java)
            startActivity(intent)
        }
        //아이템 레이아웃 설정 및 어댑터 연결
        binding!!.recyclerMongs2.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding!!.recyclerMongs2.adapter = MongsAdapter()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}

