package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMypageBinding
import com.example.metamong.fragment.home.SharemongAdapter
import com.example.metamong.fragment.home.SharemongData
import com.example.metamong.fragment.mypage.DB.Memo
import com.example.metamong.fragment.mypage.DB.MemoDB



 class MypageFragment() : Fragment(){
    private var binding: FragmentMypageBinding? = null
    private var memoDB: MemoDB? = null
    private var memolist = listOf<Memo>()

    companion object {
        fun newInstance(): MypageFragment {
            val fragment = MypageFragment()
            val args = Bundle()
            args.putInt("test", 1)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentMypageBinding.inflate(inflater, container, false)
        binding = mBinding
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

