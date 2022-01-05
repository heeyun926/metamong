package com.example.metamong.fragment.mypage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMongsMemoDetailBinding
import com.example.metamong.databinding.FragmentMypageBinding


class MongsMemoDetailFragment : Fragment() {
    private val navigationArgs: MongsMemoDetailFragmentArgs by navArgs()
    lateinit var item: Memo
    private val viewModel: MemoViewModel by activityViewModels {
        MemoViewModelFactory(
            (activity?.application as MemoApplication).database.memoDao()
        )
    }
    private var _binding: FragmentMongsMemoDetailBinding? = null
    private val binding get() = _binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMongsMemoDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun bind(memo:Memo){
        binding.apply {
            this!!.memoTitle.text =memo.memoTitle
            memoContent.text = memo.memoContent
            btnBack.setOnClickListener{
                viewModel.delete(memo)
                findNavController().navigateUp()
            }


        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = navigationArgs.itemId
        viewModel.getItem(id).observe(this.viewLifecycleOwner) {
            item = it
            bind(item)
        }

        //아이템 레이아웃 설정 및 어댑터 연결
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}




