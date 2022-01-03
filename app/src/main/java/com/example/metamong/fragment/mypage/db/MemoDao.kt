package com.example.metamong.fragment.mypage.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo_table ORDER BY memoContent ASC")
    fun getAll(): Flow<List<Memo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(memo: Memo)

    @Query("DELETE FROM memo_table")
    suspend fun deleteAll()
}