package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.databinding.FragmentMypageBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class MypageFragment() : Fragment() {
    private var binding: FragmentMypageBinding? = null
//    private val memoViewModel: MemoViewModel by sharedViewModel()
    //private val memoViewModel: MemoViewModel by viewModels() // 뷰모델 연결
    //private lateinit var memoViewModel : MemoViewModel
//    private val adapter: MongsAdapter by lazy { MongsAdapter(memoViewModel) } // 어댑터 선언



//    companion object {
//        fun newInstance(): MypageFragment {
//            val fragment = MypageFragment(memoViewModel)
//            val args = Bundle()
//            args.putInt("test", 1)
//            fragment.arguments = args
//
//            return fragment
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //뷰모델 연결(뷰모델 불러오기)
        //memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)


        val mBinding = FragmentMypageBinding.inflate(inflater, container, false)
        binding = mBinding
        //아이템 레이아웃 설정 및 어댑터 연결
        binding!!.recyclerMongs2.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding!!.recyclerMongs2.adapter = MongsAdapter()

        return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnAddMongs2?.setOnClickListener {
            val intent = Intent(context, MongsAddActivity::class.java)
            startActivity(intent)
        }

//        var memo = ""
//        arguments?.apply {
//            memo = this.getString(MongsAddActivity.EXTRA_REPLY, "fail")
//        }
//        val Memo = Memo(memo)
//        memoViewModel.insert(Memo)
//        Toast.makeText(activity, "추가", Toast.LENGTH_SHORT).show()
//


    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}

