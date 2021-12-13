package com.example.metamong.fragment.mypage.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "memo")

class Memo(@PrimaryKey var id : Long?,
           @ColumnInfo(name ="memoTitle") var memoTitle: String,
           @ColumnInfo(name = "memoContent") var memoContent: String?,
           @ColumnInfo(name = "memoImage") var memoImage: Int){

    constructor():this(null,"","",0)

}
