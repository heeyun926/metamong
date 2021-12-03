package com.example.metamong.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.MemoActivity
import com.example.metamong.R
import com.example.metamong.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private fun loadData(): MutableList<SharemongData> {
        val list = mutableListOf<SharemongData>()
        with(list) {
            add(SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_shatemong_meet,
                R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "))
            add(SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_shatemong_meet,
                R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "))
            add(SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_shatemong_meet,
                R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "))
            add(SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_shatemong_meet,
                R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "))

        }
        return list
    }

        override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val mBinding = FragmentHomeBinding.inflate(inflater, container, false)
            _binding = mBinding

            binding.recyclerSharemong.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerSharemong.adapter = SharemongAdapter()


            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.btnChat.setOnClickListener{
                val intent = Intent(context, MemoActivity::class.java)
                startActivity(intent)
            }
            val data : MutableList<SharemongData> = loadData()
            val sharemongAdapter = context?.let { SharemongAdapter() }
            sharemongAdapter?.sharemong = data
            Log.d("TAGhome", "onViewCreated: ${sharemongAdapter?.sharemong}")
            binding.recyclerSharemong.adapter = sharemongAdapter


        }


        override fun onDestroyView() {
            _binding = null
            super.onDestroyView()
        }
    }
