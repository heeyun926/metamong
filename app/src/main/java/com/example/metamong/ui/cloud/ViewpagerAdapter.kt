package com.example.metamong.ui.cloud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.model.ViewpagerData

class ViewpagerAdapter constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager_cloud, parent, false)
    )

    fun bind(viewpagerData: ViewpagerData) {
        itemView.viewpager.
    }


}