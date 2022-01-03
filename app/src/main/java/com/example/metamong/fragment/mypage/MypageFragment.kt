package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.databinding.FragmentMypageBinding
import com.example.metamong.fragment.mypage.db.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MypageFragment() : Fragment(){
    private var binding: FragmentMypageBinding? = null
    private val memoViewModel: MemoViewModel by sharedViewModel()
//    private lateinit var memoViewModel: MemoViewModel


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

    memoViewModel.allMemos.observe(viewLifecycleOwner) { memos ->
        // Update the cached copy of the words in the adapter.
        memos.let { adapter.setData(it) }
    }


    val mBinding = FragmentMypageBinding.inflate(inflater, container, false)
        binding = mBinding
    //memoViewModel = ViewModelProvider(this,MemoViewModelFactory(MemoRepository())).get(MemoViewModel::class.java)
    //아이템 레이아웃 설정 및 어댑터 연결
    binding!!.recyclerMongs2.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
    binding!!.recyclerMongs2.adapter = adapter



    return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnPlus?.setOnClickListener{
               val intent = Intent(context, MongsActivity::class.java)
               startActivity(intent)
            }
        binding?.btnAddMongs2?.setOnClickListener {
            val intent = Intent(context, MongsAddActivity::class.java)
            startActivity(intent)
        }

    }



    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}

