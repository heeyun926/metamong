package com.example.metamong.fragment.mypage

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo_table ORDER BY memoContent ASC")
    fun getAll(): Flow<List<Memo>>

    @Query("SELECT * from memo_table WHERE id = :id")
    fun getItem(id: Int): Flow<Memo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(memo: Memo)

    @Update
    suspend fun update(memo:Memo)

    @Query("DELETE FROM memo_table")
    suspend fun deleteAll()
}