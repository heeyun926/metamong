package com.example.metamong.fragment.mypage

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "memo_table")
data class Memo(@PrimaryKey @NonNull
                @ColumnInfo var memoContent: String)
                //@ColumnInfo(name ="memoBG") var memoBg: Bitmap? = null,
                //@ColumnInfo(name = "memoTitle") var memoTitle: String)
                //@ColumnInfo(name = "memoContent") var memoContent: String?)

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
