package com.example.metamong.notworked.memodb

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import com.example.metamong.Memo
import com.example.metamong.databinding.ItemRecyclermemoBinding


//RoomMemo Table
@Entity(tableName = "room_memo")
class RoomMemo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var no: Long?,
    @ColumnInfo var title: String?,
    @ColumnInfo var content: String?,

    )


//RoomMemoDao
@Dao
interface RoomMemoDao {
    @Query("Select*from room_memo")
    fun getAll(): List<RoomMemo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

}


//RoomMemo Database
@Database(entities = [RoomMemo::class], version = 1)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun roomMemoDao(): RoomMemoDao

    companion object {
        //singleton prevents multiple instances of database opening at the sametime
        @Volatile
        private var INSTANCE: MemoDatabase? = null
        fun getInstance(context: Context): MemoDatabase? {
            var instance = INSTANCE
            if (instance == null) {
                synchronized(MemoDatabase::class.java) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        MemoDatabase::class.java, "memo_db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }

    }
}



//RoomMemoAdapter
class MemoAdapter(val roomMemoList: List<RoomMemo>) : RecyclerView.Adapter<MemoAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclermemoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setMemo(roomMemoList.get(position))
    }

    override fun getItemCount() = roomMemoList.size

    class Holder(val binding: ItemRecyclermemoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setMemo(roomMemo: RoomMemo) {
            with(binding) {
                memoNo.text = "${roomMemo.no}"
                memoContent.text = roomMemo.content
                memoTitle.text = roomMemo.title

            }
        }
    }
}