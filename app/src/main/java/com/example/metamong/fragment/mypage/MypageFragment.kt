package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMypageBinding


class MypageFragment : Fragment() {
    private val viewModel: MemoViewModel by activityViewModels {
        MemoViewModelFactory(
            (activity?.application as MemoApplication).database.memoDao()
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

        val adapter = MemoListAdapter {
            val action =
                MypageFragmentDirections.actionMypageFragmentToMongsMemoDetailFragment(it.id)
            this.findNavController().navigate(action)
        }

        //아이템 레이아웃 설정 및 어댑터 연결
        binding!!.recyclerMongs2.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)
//            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding!!.recyclerMongs2.adapter = adapter
        viewModel.allMemos.observe(this.viewLifecycleOwner) { items ->
            items.let {
                adapter.submitList(it)
            }

        }
        binding!!.btnAddMongs2.setOnClickListener {
            val action = MypageFragmentDirections.actionMypageFragmentToMongsMemoAddFragement(
                getString(R.string.app_name)
            )
            this.findNavController().navigate(action)
        }
    }
}
