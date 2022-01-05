package com.example.metamong.fragment.mypage

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MemoApplication : Application(){
    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { MemoDB.getInstance(this, applicationScope) }
//    val repository by lazy { database.memoDao() }
}