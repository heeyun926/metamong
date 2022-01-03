package com.example.metamong.fragment.mypage.DB

import androidx.annotation.WorkerThread
import com.example.metamong.fragment.mypage.MypageFragment
import kotlinx.coroutines.flow.Flow

class MemoRepository(private val memoDao: MemoDao){

    val allMemos: Flow<List<Memo>> = memoDao.getAll()


    @WorkerThread
    suspend fun insert(memo:Memo){
        memoDao.insert(memo)

    }
}