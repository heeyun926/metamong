package com.example.metamong.fragment.mypage

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class MemoApplication : Application(){
    val appModule = module {
        val applicationScope = CoroutineScope(SupervisorJob())

        single {
            MemoDB.getInstance(androidApplication(), applicationScope)
        }
        single {
            MemoRepository(get())
        }
        single {
            get<MemoDB>().memoDao()
        }
        viewModel {
            MemoViewModel(get())
            MemoViewModel2(get())
        }

    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MemoApplication)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(appModule)
        }
    }
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { MemoDB.getInstance(this, applicationScope) }
    val repository by lazy { MemoRepository(database.memoDao()) }


}