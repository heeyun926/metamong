package com.example.metamong.fragment.mypage.DB

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.reflect.KParameter


@Database(entities = [Memo::class], version = 1)
//@TypeConverters(Converters::class)
abstract class MemoDB : RoomDatabase(){
    abstract fun memoDao(): MemoDao

    companion object {
        @Volatile
        private var instance: MemoDB? = null

        fun getInstance(context: Context, applicationScope: CoroutineScope): MemoDB {
            return instance ?: synchronized(this) {
                val INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MemoDB::class.java, "memo_database"
                ).build()
                instance = INSTANCE
                INSTANCE
            }
        }

        private class MemoDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.let { database ->
                    scope.launch {
                        val memoDao = database.memoDao()
                        //Delete all
                        memoDao.deleteAll()

                    }
                }
            }
        }
    }
}

