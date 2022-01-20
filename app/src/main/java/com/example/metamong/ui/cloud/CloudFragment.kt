package com.example.metamong.ui.cloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets.add
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.databinding.FragmentCloudBinding
import com.example.metamong.model.ViewpagerData
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


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}