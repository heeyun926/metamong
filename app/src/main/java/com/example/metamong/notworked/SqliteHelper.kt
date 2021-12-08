package com.example.metamong

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import androidx.room.Entity



data class Memo(var no:Long?, var content:String, var datetime: Long)

class SqliteHelper(context: Context, name:String, version:Int) : SQLiteOpenHelper(context,name,null,version){
    override fun onCreate(p0: SQLiteDatabase?) {
        val create ="create table memo('no' integer primary key, content text, datetime integer)"
        p0?.execSQL(create)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        //table 변경시 호출 - sqliteHelper()의 생성자 호풀 시 기존 db와 version 비교 후 높으면 호출

    }
    //insert function
    fun insertMemo(memo:Memo){
        //memo-> insert type
        val values = ContentValues()
        values.put("content",memo.content)
        values.put("datetime",memo.datetime)
        // insert db
        val wd = writableDatabase
        wd.insert("memo",null,values)
        wd.close()

    }
    //select function
    @SuppressLint("Range")
    fun selectMemo(): MutableList<Memo>{
        val list = mutableListOf<Memo>()
        val select = "select * from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select,null)
        while(cursor.moveToNext()){
            val no = cursor.getLong(cursor.getColumnIndex("no"))
            val content = cursor.getString(cursor.getColumnIndex("content"))
            val datetime = cursor.getLong(cursor.getColumnIndex("datetime"))

            val memo = Memo(no,content,datetime)
            list.add(memo)
        }
        cursor.close()
        rd.close()
        return list
    }
    //update function
    fun updateMemo(memo:Memo){
        val values = ContentValues()
        values.put("content",memo.content)
        values.put("datetime",memo.datetime)

        val wd = writableDatabase
        wd.update("memo",values,"no=${memo.no}",null)
        wd.close()

    }
    //delete function
    fun deleteMemo(memo:Memo){
        val wd =writableDatabase
        //sql used
        //val delete = "delete from memo where no = ${memo.no}"
        //wd.execSQL(delete)

        wd.delete("memo","no=${memo.no}",null)
        wd.close()
    }
}