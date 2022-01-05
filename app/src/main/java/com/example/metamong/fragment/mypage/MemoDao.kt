package com.example.metamong.fragment.mypage

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Query("SELECT * FROM Memo ORDER BY memoContent ASC")
    fun getAll(): Flow<List<Memo>>

    @Query("SELECT * from Memo WHERE id = :id")
    fun getItem(id: Int): Flow<Memo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(memo: Memo)

    @Update
    suspend fun update(memo:Memo)

    @Delete
    suspend fun deleteAll(memo:Memo)
}