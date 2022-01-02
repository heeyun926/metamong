package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.databinding.FragmentMypageBinding
import com.example.metamong.fragment.mypage.DB.*


class MypageFragment() : Fragment(){
    private var binding: FragmentMypageBinding? = null
    private lateinit var memoViewModel: MemoViewModel
//    private val memoViewModel : MemoViewModel by viewModels()

    private val adapter : MongsAdapter by lazy { MongsAdapter(memoViewModel) }
/**
    companion object {
        fun newInstance(): MypageFragment {
            val fragment = MypageFragment()
            val args = Bundle()
            args.putInt("test", 1)
            fragment.arguments = args

            return fragment
        }
    }**/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    memoViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
        .get(MemoViewModel::class.java)


    val mBinding = FragmentMypageBinding.inflate(inflater, container, false)
        binding = mBinding
    //memoViewModel = ViewModelProvider(this,MemoViewModelFactory(MemoRepository())).get(MemoViewModel::class.java)
    //아이템 레이아웃 설정 및 어댑터 연결
    binding!!.recyclerMongs2.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
    binding!!.recyclerMongs2.adapter = adapter

    memoViewModel.allMemos.observe(viewLifecycleOwner, Observer {
        adapter.setData(it)
    })

    return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnPlus?.setOnClickListener{
               val intent = Intent(context, MongsActivity::class.java)
               startActivity(intent)
            }

    }



    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}

