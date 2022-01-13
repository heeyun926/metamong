package com.example.metamong.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class HistoryData (@PrimaryKey(autoGenerate = true) val id:Int =0,
                   @ColumnInfo(name = "btn") val plus : Int

        )