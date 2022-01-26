package com.example.metamong.model

import android.content.Context
import android.os.Parcelable

data class ViewpagerData (
    val text: String,
    val viewpagerList: MutableList<ViewpagerRecyclerData>
    )
data class ViewpagerRecyclerData(
    val text: String
)
