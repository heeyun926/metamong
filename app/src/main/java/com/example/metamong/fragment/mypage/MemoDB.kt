package com.example.metamong.fragment.mypage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Memo::class], version = 3)
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
                )
                    .addCallback(MemoDatabaseCallback(applicationScope))
                    .fallbackToDestructiveMigration()
                    .build()
                instance = INSTANCE
                INSTANCE

            }
        }
    }

        private class MemoDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.let { database ->
                    scope.launch (Dispatchers.IO){
                        baseDatabase(database.memoDao())

                    }
                }
            }
            suspend fun baseDatabase(memoDao: MemoDao) {
                memoDao.deleteAll()

                val memo = Memo("reply")
                memoDao.insert(memo)
            }
        }
    }


