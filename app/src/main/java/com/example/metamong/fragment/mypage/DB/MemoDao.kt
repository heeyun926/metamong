package com.example.metamong.fragment.mypage.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo_table")
    fun getAll(): Flow<List<Memo>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(memo: Memo)

    @Query("DELETE from memo_table")
    suspend fun deleteAll()
}