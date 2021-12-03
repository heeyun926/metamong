package com.example.metamong.fragment


import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets.add
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.MemoActivity
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHomeSubBinding
import com.example.metamong.databinding.FragmentHomeBinding
import com.example.metamong.main.SharemongAdapter
import com.example.metamong.main.SharemongData
import kotlinx.coroutines.NonDisposableHandle.parent

class HomeFragment : Fragment() {

    private val recyclerViewsharemong : RecyclerView by lazy {
        view?.findViewById(R.id.recyclerSharemong) as RecyclerView
    }
    private val sharemongdata by lazy {
        mutableListOf<SharemongData>(
            SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_sharemong_bg,
                R.drawable.ic_sharemong_text_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "),
            SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_sharemong_bg,
                R.drawable.ic_sharemong_text_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "),
            SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_sharemong_bg,
                R.drawable.ic_sharemong_text_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 "),
            SharemongData(R.drawable.meet_i_b,
                R.drawable.ic_sharemong_bg,
                R.drawable.ic_sharemong_text_bg, "심리치료", "직접 케이스를 만나보고\n실제로 대화를 건네보는 체험 ")
        )
    }
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



            // main sharemong list
            val sharemong : MutableList<SharemongData> = sharemongdata
            val sharemongAdapter = SharemongData
            sharemongAdapter.sharemong = sharemong
            binding.recyclerSharemong.adapter = sharemongAdapter


        }




        override fun onDestroyView() {
            _binding = null
            super.onDestroyView()
        }
    }
}