package com.example.metamong.fragment.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMypageBinding

class MypageFragment: Fragment() {
    private var binding : FragmentMypageBinding? = null

    fun loadData(): MutableList<MongsData> {
        val list = mutableListOf<MongsData>()
        with(list){
            add(
                MongsData(R.drawable.ic_mongsmemo_bg,
            R.drawable.ic_sharemong_text_bg,
            R.drawable.ic_mongsmemo_image_bg,
            "uxui designer", "진로페어 미션 수행중"))
            add(MongsData(R.drawable.ic_mongsmemo_bg,
                R.drawable.ic_sharemong_text_bg,
                R.drawable.ic_mongsmemo_image_bg,
                "uxui designer", "진로페어 미션 수행중"))
            add(MongsData(R.drawable.ic_mongsmemo_bg,
                R.drawable.ic_sharemong_text_bg,
                R.drawable.ic_mongsmemo_image_bg,
                "uxui designer", "진로페어 미션 수행중"))
        }
        return list
    }
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentMypageBinding.inflate(inflater,container,false)
        binding = mBinding
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : MutableList<MongsData> = loadData()
        var mongsAdapter = context?.let{MongsAdapter()}
        mongsAdapter?.mongsMemo = data
    }

    override fun onDestroyView() {
        binding =null
        super.onDestroyView()
    }
}