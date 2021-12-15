package com.example.metamong.fragment.mypage.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class MemoDB : RoomDatabase(){
    abstract fun memoDao(): MemoDao

    companion object {
        @Volatile
        private var instance: MemoDB? = null

        fun getInstance(context: Context?): MemoDB?{
            if(instance == null) {
                synchronized(MemoDB::class){
                    instance = Room.databaseBuilder(context!!.applicationContext,
                    MemoDB::class.java,"memo.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance(){
            instance = null
        }
    }
}