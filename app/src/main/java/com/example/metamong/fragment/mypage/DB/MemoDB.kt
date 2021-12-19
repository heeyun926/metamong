package com.example.metamong.fragment.mypage.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class MemoDB : RoomDatabase(), MemoDao {
    abstract fun memoDao(): MemoDao

    companion object {
        @Volatile
        private var instance: MemoDB? = null

        fun getInstance(context: Context): MemoDB {
            return instance ?: synchronized(this) {
                val INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MemoDB::class.java, "memo_database"
                ).build()
                instance = INSTANCE
                INSTANCE
            }
        }
    }
}

