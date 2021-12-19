package com.example.metamong.fragment.mypage.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "memo_table")

class Memo(@PrimaryKey var id : Long?,
           @ColumnInfo(name ="memoBG") var memoBg: Int,
           @ColumnInfo(name ="memoContentBg") var memoContentBg: Int,
           @ColumnInfo(name ="memoImgBg") var memoImgBg: Int,
           @ColumnInfo(name = "memoTitle") var memoTitle: String,
           @ColumnInfo(name = "memoContent") var memoContent: String?){

    constructor():this(null,0,0,0,"","")

}
