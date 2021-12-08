package com.example.metamong

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.metamong.databinding.ActivityMemoBinding
import com.example.metamong.databinding.ItemRecyclermemoBinding
import com.example.metamong.main.HomeActivity_Sub
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import java.text.SimpleDateFormat

class MemoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoBinding
    lateinit var helper: RoomHelper
    lateinit var memoadapter : MemoAdapter
    val memolist = mutableListOf<RoomMemo>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helper = Room.databaseBuilder(this, RoomHelper::class.java,"room_memo")
            .build()

        memolist.addAll(helper.roomMemoDao().getAll())
        memoadapter = MemoAdapter(memolist)

        with(binding){
            recyclerMemo.adapter = memoadapter
            recyclerMemo.layoutManager =LinearLayoutManager(this@MemoActivity)

            btnAdd.setOnClickListener {
                val content =editMemo.text.toString()
                if (content.isNotEmpty()) {
                    val datetime =System.currentTimeMillis()
                    val memo = RoomMemo(content,datetime)
                    editMemo.setText("")
                    //insertMemo(memo)
                }
            }
        }
        binding.btnSave.setOnClickListener{
            Intent(this, HomeActivity_Sub::class.java)
            finish()
        }
    }
    fun insertMemo(memo:RoomMemo){
        CoroutineScope(Dispatchers.IO).launch {
            helper.roomMemoDao().insert(memo)
            refreshAdapter()
        }
    }
    fun refreshAdapter(){
        CoroutineScope(Dispatchers.IO).launch {
            memolist.clear()
            memolist.addAll(helper.roomMemoDao().getAll())
            withContext(Dispatchers.Main){
                memoadapter.notifyDataSetChanged()
            }
        }
    }
}


//RoomMemo Entity
@Entity(tableName = "room_memo")
class RoomMemo{
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo
    var no: Long? = null
    @ColumnInfo
    var content: String? = ""
    @ColumnInfo
    var datetime: Long = 0

    constructor(content:String, datetime: Long){
        this.content = content
        this.datetime = datetime
    }
}
//RoomMemoDao
@Dao
interface RoomMemoDao {
    @Query("Select*from room_memo")
    fun getAll():List<RoomMemo>

    @Insert(onConflict = REPLACE)
    fun insert(memo: RoomMemo)

    @Delete
    fun delete(memo: RoomMemo)
}
//RoomMemo Helper
@Database(entities = [RoomMemo::class], version = 1, exportSchema = false)
abstract class RoomHelper: RoomDatabase(){
    abstract fun roomMemoDao(): RoomMemoDao

    companion object {
        //singleton prevents multiple instances of database opening at the sametime
        @Volatile
        private var INSTANCE: RoomHelper? = null
        fun getDatabase(context: Context): RoomHelper{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return (INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomHelper::class.java,
                    "memo db"
                ).build()
                INSTANCE =instance
                        instance
            })

        }
    }
}

//RoomMemoAdapter
class MemoAdapter(val roomMemoList:List<RoomMemo>): RecyclerView.Adapter<MemoAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoAdapter.Holder {
        val binding = ItemRecyclermemoBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MemoAdapter.Holder, position: Int) {
        holder.setMemo(roomMemoList.get(position))
    }

    override fun getItemCount() = roomMemoList.size

    class Holder(val binding:ItemRecyclermemoBinding) : RecyclerView.ViewHolder(binding.root){
        fun setMemo(roomMemo:RoomMemo){
            with(binding){
                memoNo.text ="${roomMemo.no}"
                memoContent.text = roomMemo.content
                val sdf = SimpleDateFormat("MM/dd hh")
                memoDatetime.text = sdf.format(roomMemo.datetime)
            }
        }
    }
}