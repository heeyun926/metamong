package com.example.metamong.fragment.mypage

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow

class MemoRepository (private val memoDao: MemoDao){
    val allMemos: Flow<List<Memo>> = memoDao.getAll()

    @WorkerThread
    suspend fun insert(memo: Memo){
        memoDao.insert(memo)
    }
    suspend fun update(memo: Memo){
        memoDao.update(memo)
    }
    suspend fun delete(memo: Memo){
        memoDao.deleteAll()
    }
    fun getItem(id:Int){
        memoDao.getItem(id).asLiveData()
    }

}