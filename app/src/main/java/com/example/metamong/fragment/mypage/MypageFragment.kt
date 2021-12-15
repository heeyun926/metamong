package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMypageBinding
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

    fun loadData(): MutableList<MongsData> {
        val list = mutableListOf<MongsData>()
        with(list) {
            add(
                MongsData(
                    R.drawable.ic_mongsmemo_bg,
                    R.drawable.ic_sharemong_text_bg,
                    R.drawable.ic_mongsmemo_image_bg,
                    "uxui designer", "진로페어 미션 수행중"
                )
            )
            add(
                MongsData(
                    R.drawable.ic_mongsmemo_bg,
                    R.drawable.ic_sharemong_text_bg,
                    R.drawable.ic_mongsmemo_image_bg,
                    "uxui designer", "진로페어 미션 수행중"
                )
            )
            add(
                MongsData(
                    R.drawable.ic_mongsmemo_bg,
                    R.drawable.ic_sharemong_text_bg,
                    R.drawable.ic_mongsmemo_image_bg,
                    "uxui designer", "진로페어 미션 수행중"
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
        val mBinding = FragmentMypageBinding.inflate(inflater, container, false)
        binding = mBinding



        return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //room getInstance
        memoDB = context?.let { MemoDB.getInstance(it) }
        val r = Runnable {
            memolist = memoDB?.memoDao()?.getAll()!!
        }
        val thread = Thread(r)
        thread.start()

        //data.binding
        val mAdapter = MongsAdapter(this, memolist)
        mAdapter.notifyDataSetChanged()
        with(binding) {
            this!!.recyclerMongs.adapter = mAdapter
            recyclerMongs.layoutManager = LinearLayoutManager(context)
            recyclerMongs.setHasFixedSize(true)
        }

        binding?.btnAddMemo?.setOnClickListener {
            val intent = Intent(context, MongsAddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}

