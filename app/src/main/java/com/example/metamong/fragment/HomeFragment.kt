package com.example.metamong.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.metamong.R
import com.example.metamong.databinding.FragmentCloudBinding
import com.example.metamong.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = mBinding
        return binding?.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}