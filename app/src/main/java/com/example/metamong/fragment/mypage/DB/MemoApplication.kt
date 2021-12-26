package com.example.metamong.fragment.mypage.DB

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MemoApplication : Application(){
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { MemoDB.getInstance(this,applicationScope) }
    val repository by lazy { MemoRepository(database.memoDao()) }
}