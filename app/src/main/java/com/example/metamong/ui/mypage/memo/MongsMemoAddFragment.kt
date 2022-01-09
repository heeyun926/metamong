package com.example.metamong.ui.mypage.memo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.metamong.R
import com.example.metamong.databinding.FragmentMongsMemoAddBinding
import com.example.metamong.ui.main.HomeActivity_Sub


class MongsMemoAddFragment : Fragment() {
    private val viewModel: MemoViewModel by activityViewModels {
        MemoViewModelFactory(
            (activity?.application as MemoApplication).database.memoDao()
        )
    }
    private val navigationArgs: MongsMemoAddFragmentArgs by navArgs()
    lateinit var memo: Memo
    private var _binding: FragmentMongsMemoAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //BottomNav hide
        val homesubAct = activity as HomeActivity_Sub
        homesubAct.HideBottomNavi(true)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentMongsMemoAddBinding.inflate(inflater, container, false)
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

    private fun addNewMemo() {
        if (isEntryValid()) {
            viewModel.addNewMemo(
                binding.editTextTitle.text.toString(),
                binding.editTextContent.text.toString(),
            )
            val action =
                MongsMemoAddFragmentDirections.actionMongsMemoAddFragementToMypageFragment()
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
            val action =
                MongsMemoAddFragmentDirections.actionMongsMemoAddFragementToMypageFragment()
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
                addNewMemo()
            }
        }

        binding.backBtn.setOnClickListener {
            onDestroyView()
        }


        val dataMongsMemo = resources.getStringArray(R.array.mongs_memo)

        val list = mutableListOf<Int>()
        list.add(R.drawable.mobile_side)
        list.add(R.drawable.desktop_main)
        list.add(R.drawable.circle_bottle)
        list.add(R.drawable.pencil)
        list.add(R.drawable.long_bottle)

        val arrayAdapter = activity?.let {
            ArrayAdapter<String>(it.baseContext, R.layout.spinner_text, dataMongsMemo)
        }
        arrayAdapter?.setDropDownViewResource(R.layout.spinner_text)

        binding.spinner.adapter = arrayAdapter


//        val adapter = activity?.let {
//            ArrayAdapter<String>(
//                it.baseContext,
//                R.layout.support_simple_spinner_dropdown_item,
//                dataMongsMemo
//            )
//        }
        with(binding) {
            spinner.adapter = arrayAdapter

            spinner.setSelection(0) //시작 위치 지정
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    val selected = dataMongsMemo[position]
                    resultText.text = selected
                    if (position == 0) {
                        imageView9.setImageResource(R.drawable.ic_mongsmemo_content_bg)
                    }else{
                        imageView9.setImageResource(list[position-1])
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
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

        //BottomNav See
        val homesubAct = activity as HomeActivity_Sub
        homesubAct.HideBottomNavi(false)
    }
}