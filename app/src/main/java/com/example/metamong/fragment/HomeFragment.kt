package com.example.metamong.fragment


import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import com.example.metamong.MemoActivity
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeSubBinding
import com.example.metamong.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding = mBinding
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnChat.setOnClickListener{
            val intent = Intent(context, MemoActivity::class.java)
            startActivity(intent)
        }



    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}