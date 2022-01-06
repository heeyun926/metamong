package com.example.metamong.ui.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.R
import com.example.metamong.databinding.FragmentHomeBinding
import com.example.metamong.fragment.home.SharemongData
import com.example.metamong.model.LookTalkData


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private fun loadData(): MutableList<SharemongData> {
        val list = mutableListOf<SharemongData>()
        with(list) {
            add(
                SharemongData(
                    R.drawable.meet_i_b,
                    R.drawable.ic_shatemong_meet,
                    R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "
                )
            )
            add(
                SharemongData(
                    R.drawable.meet_i_b,
                    R.drawable.ic_shatemong_meet,
                    R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "
                )
            )
            add(
                SharemongData(
                    R.drawable.meet_i_b,
                    R.drawable.ic_shatemong_meet,
                    R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "
                )
            )
            add(
                SharemongData(
                    R.drawable.meet_i_b,
                    R.drawable.ic_shatemong_meet,
                    R.drawable.ic_sharemong_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "
                )
            )

        }
        return list
    }

    private fun loadData2(): MutableList<LookTalkData> {
        val list = mutableListOf<LookTalkData>()
        with(list) {
            add(
                LookTalkData(
                    R.drawable.ic_looktalk_bg,
                    R.drawable.looktalk_image_1,
                    R.drawable.ic_looktalk_date, "Android?", "안드로이드 기본 개념 위... ","D-day"
                )
            )
            add(
                LookTalkData(
                    R.drawable.ic_looktalk_bg,
                    R.drawable.looktalk_image_1,
                    R.drawable.ic_looktalk_date, "Android?", "안드로이드 기본 개념 위... ","D-day"
                )
            )
            add(
                LookTalkData(
                    R.drawable.ic_looktalk_bg,
                    R.drawable.looktalk_image_1,
                    R.drawable.ic_looktalk_date, "Android?", "안드로이드 기본 개념 위... ","D-day"
                )
            )
            add(
                LookTalkData(
                    R.drawable.ic_looktalk_bg,
                    R.drawable.looktalk_image_1,
                    R.drawable.ic_looktalk_date, "Android?", "안드로이드 기본 개념 위... ","D-day"
                )
            )
            add(
                LookTalkData(
                    R.drawable.ic_looktalk_bg,
                    R.drawable.looktalk_image_1,
                    R.drawable.ic_looktalk_date, "Android?", "안드로이드 기본 개념 위... ","D-day"
                )
            )


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


        binding.recyclerSharemong.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerSharemong.adapter = SharemongAdapter()

        binding.lookTalkrecycler.layoutManager =
            LinearLayoutManager(context, GridLayoutManager.HORIZONTAL, false)
        binding.lookTalkrecycler.adapter = SharemongAdapter()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//            binding.btnChat.setOnClickListener{
//                val intent = Intent(context, MemoActivity::class.java)
//                startActivity(intent)
//            }
        val data: MutableList<SharemongData> = loadData()
        val data2: MutableList<LookTalkData> = loadData2()
        val sharemongAdapter = context?.let { SharemongAdapter() }
        sharemongAdapter?.sharemong = data
        //sharemongAdapter?.sharemong = data2
        Log.d("TAGhome", "onViewCreated: ${sharemongAdapter?.sharemong}")

        binding.recyclerSharemong.adapter = sharemongAdapter
        binding.lookTalkrecycler.adapter = sharemongAdapter


    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
