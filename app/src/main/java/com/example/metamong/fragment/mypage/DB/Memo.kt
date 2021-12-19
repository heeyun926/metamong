package com.example.metamong.fragment.mypage.DB

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "memo_table")
data class Memo(@PrimaryKey @NonNull var memo : String,
           @ColumnInfo(name ="memoBG") var memoBg: Int,
           @ColumnInfo(name ="memoContentBg") var memoContentBg: Int,
           @ColumnInfo(name ="memoImgBg") var memoImgBg: Int,
           @ColumnInfo(name = "memoTitle") var memoTitle: String,
           @ColumnInfo(name = "memoContent") var memoContent: String?)



