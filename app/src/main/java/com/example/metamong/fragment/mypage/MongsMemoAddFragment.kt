package com.example.metamong.fragment.mypage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.metamong.databinding.FragmentMongsMemoAddBinding


class MongsMemoAddFragment : Fragment() {
    private val viewModel: MemoViewModel by activityViewModels {
        MemoViewModelFactory(
            (activity?.application as MemoApplication).repository
        )
    }
    private val navigationArgs: MongsMemoAddFragmentArgs by navArgs()
    lateinit var memo: Memo
    private var _binding: FragmentMongsMemoAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMongsMemoAddBinding.inflate(inflater,container, false)
        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.editTextTitle.text.toString(),
            binding.editTextContent.text.toString(),
        )
    }

    private fun bind(memo: Memo) {
        binding.apply {
            editTextTitle.setText(memo.memoTitle, TextView.BufferType.SPANNABLE)
            editTextContent.setText(memo.memoContent, TextView.BufferType.SPANNABLE)
            MongsSaveBtn.setOnClickListener { updateItem() }
        }
    }
    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewMemo(
                binding.editTextTitle.text.toString(),
                binding.editTextContent.text.toString(),
            )
            val action = MongsMemoAddFragmentDirections.actionMongsMemoAddFragementToMypageFragment()
            findNavController().navigate(action)
        }
    }

    private fun updateItem() {
        if (isEntryValid()) {
            viewModel.updateItem(
                this.navigationArgs.memoId,
                this.binding.editTextTitle.text.toString(),
                this.binding.editTextContent.text.toString()
            )
            val action = MongsMemoAddFragmentDirections.actionMongsMemoAddFragementToMypageFragment()
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = navigationArgs.memoId
        if (id > 0) {
            viewModel.getItem(id).observe(this.viewLifecycleOwner) {
                memo = it
                bind(memo)
            }
        } else {
            binding.MongsSaveBtn.setOnClickListener {
                addNewItem()
            }
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }

//    companion object {
//
//        fun newInstance(param1: String, param2: String) =
//            MongsMemoAddFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}