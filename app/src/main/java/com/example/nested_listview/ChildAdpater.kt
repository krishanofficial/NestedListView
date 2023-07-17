package com.example.nested_listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class ChildAdpater(val context: Context, val DataList:List<ChildDataModel>) : BaseAdapter()  {
    override fun getCount(): Int {
        return DataList.size
    }

    override fun getItem(p0: Int): Any {
        return DataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.child_item_listview, p2, false)
       val logo=view.findViewById<ImageView>(R.id.childLogo)
        val title=view.findViewById<TextView>(R.id.childTitle)
        val data=DataList[p0]
        Glide.with(context).load(data.logo).into(logo);
        title.text=DataList[p0].title
        return view
    }
}