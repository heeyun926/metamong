package com.example.metamong.fragment.mypage.DB

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MemoViewModel(application:Application) : AndroidViewModel(application){

    val allMemos : LiveData<List<Memo>>
    private val repository: MemoRepository
    //= repository.allMemos.asLiveData()
    // get set
    private var _currentData = MutableLiveData<List<Memo>>()
    val currentData : LiveData<List<Memo>>
        get() = _currentData

    init{
        val memoDao = MemoDB.getInstance(application)!!.memoDao()
        repository = MemoRepository(memoDao)
        allMemos = repository.allMemos.asLiveData()

    }

    fun insert(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(memo)
    }
}
/**
class MemoViewModelFactory(private val repository: MemoRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MemoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}**/