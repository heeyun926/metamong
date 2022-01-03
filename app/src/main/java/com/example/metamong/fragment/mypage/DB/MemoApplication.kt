package com.example.metamong.fragment.mypage.DB

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MemoApplication : Application(){
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { MemoDB.getInstance(this) }
    val repository by lazy { MemoRepository(database.memoDao()) }
}