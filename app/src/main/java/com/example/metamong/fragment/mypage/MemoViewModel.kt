package com.example.metamong.fragment.mypage

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MemoViewModel(private val memoDao: MemoDao) : ViewModel(){
    val allMemos: LiveData<List<Memo>> = memoDao.getAll().asLiveData()


    fun addNewMemo(memoTitle: String, memoContent: String) {
        val newMemo = getNewMemoEntry(memoTitle,memoContent)
        insert(newMemo)
    }
    fun updateItem(
        memoId: Int,
        memoTitle: String,
        memoContent: String,
    ) {
        val updatedItem = getUpdatedItemEntry(memoId, memoTitle, memoContent)
        updateItem(updatedItem)
    }
    private fun updateItem(memo: Memo) {
        viewModelScope.launch {
            memoDao.update(memo)
        }
    }
    private fun getUpdatedItemEntry(
        memoId: Int,
        memoTitle: String,
        memoContent: String

    ): Memo {
        return Memo(
            id = memoId,
            memoContent = memoTitle,
            memoTitle = memoContent
        )
    }

    fun insert(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        memoDao.insert(memo)
    }
    fun delete(memo: Memo){
        viewModelScope.launch {
            memoDao.deleteAll(memo)
        }
    }
    fun getItem(id:Int) :LiveData<Memo>{
        return memoDao.getItem(id).asLiveData()
    }



        fun isEntryValid(memoTitle: String,memoContent: String): Boolean {
            if (memoTitle.isBlank() || memoContent.isBlank()) {
                return false
            }
            return true
        }
    }


    private fun getNewMemoEntry(memoTitle: String,memoContent: String): Memo {
        return Memo(
            memoTitle = memoTitle,
            memoContent = memoContent
        )
    }




class MemoViewModelFactory(private val memodao: MemoDao): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MemoViewModel(memodao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}