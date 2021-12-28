package com.example.metamong.fragment.mypage.DB

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MemoViewModel(private val repository: MemoRepository) : ViewModel(){
    val allMemos: LiveData<List<Memo>> = repository.allMemos.asLiveData()

    fun insert(memo: Memo) = viewModelScope.launch {
        repository.insert(memo)
    }
}

class MemoViewModelFactory(private val repository: MemoRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemoViewModel::class.java)){
            return MemoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}