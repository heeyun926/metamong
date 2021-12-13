package com.example.metamong.fragment.mypage.DB

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.metamong.fragment.mypage.MypageFragment

@Database(entities = [Memo::class], version = 1)
abstract class MemoDB : RoomDatabase(){
    abstract fun memoDao(): MemoDao

    companion object {
        private var instance: MemoDB? = null

        fun getInstance(context: MypageFragment): MemoDB?{
            if(instance == null) {
                synchronized(MemoDB::class){
                    instance = Room.databaseBuilder(context.applicationContext,
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