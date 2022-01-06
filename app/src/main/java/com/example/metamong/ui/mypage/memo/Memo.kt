package com.example.metamong.ui.mypage.memo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat


@Entity
data class Memo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "memoTitle") val memoTitle: String,
    @ColumnInfo(name = "memoContent")
    val memoContent: String)
//@ColumnInfo(name ="memoBG") var memoBg: Bitmap? = null,


/**
class Converters {
    //Bitmap -> ByteArray 변환
    @TypeConverter
    fun toByteArray(bitmap: Bitmap) : ByteArray{
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream)
        return outputStream.toByteArray()
    }
    //Byte -> Bitmap
    @TypeConverter
    fun toBitmap(bytes : ByteArray) : Bitmap{
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}
**/
