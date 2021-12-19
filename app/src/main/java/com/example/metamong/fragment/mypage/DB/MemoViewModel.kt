package com.example.metamong.fragment.mypage.DB

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MemoViewModel(private val repository: MemoRepository) : ViewModel(){
    val allMemos: LiveData<List<Memo>> = repository.allMemos.asLiveData()

    fun insert(memo: Memo) = viewModelScope.launch {
        repository.insert(memo)
    }
}