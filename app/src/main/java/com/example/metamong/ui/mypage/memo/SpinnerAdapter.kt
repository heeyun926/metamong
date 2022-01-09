package com.example.metamong.ui.mypage.memo

import android.R

import android.widget.TextView

import android.view.ViewGroup

import android.view.LayoutInflater

import android.widget.BaseAdapter




class SpinnerAdapter {
}
class AdapterSpinner(context: Context, data: List<String>?) :
    BaseAdapter() {
    var mContext: Context
    var Data: List<String>?
    var Inflater: LayoutInflater
    override fun getCount(): Int {
        return if (Data != null) Data!!.size else 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? { //처음에 클릭전에 보여지는 레이아웃
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = Inflater.inflate(R.layout.spinner_custom, parent, false)
        }
        if (Data != null) {
            val text = Data!![position]
            (convertView.findViewById(R.id.spinnerText) as TextView).text = text
        }
        return convertView
    }

    override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? { //클릭 후 보여지는 레이아웃
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = Inflater.inflate(R.layout.spinner_getview, parent, false)
        }
        val text = Data!![position]
        (convertView.findViewById(R.id.spinnerText) as TextView).text = text
        return convertView
    }

    override fun getItem(position: Int): Any {
        return Data!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    init {
        mContext = context
        Data = data
        Inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
    }
}