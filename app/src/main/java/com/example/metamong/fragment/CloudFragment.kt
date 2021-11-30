package com.example.metamong.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.metamong.R
import com.example.metamong.databinding.FragmentCloudBinding

class CloudFragment : Fragment() {
    private var binding : FragmentCloudBinding? = null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding =FragmentCloudBinding.inflate(inflater,container,false)
        binding = mBinding
        return binding?.root
    }

    override fun onDestroyView() {
        binding =null
        super.onDestroyView()
    }
}