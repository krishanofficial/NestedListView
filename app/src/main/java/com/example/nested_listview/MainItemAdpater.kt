package com.example.nested_listview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainItemAdpater(private val datalist: List<DataModel>):RecyclerView.Adapter<MainItemAdpater.ParentViewHolder>() {

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mainLogo: ImageView = itemView.findViewById(R.id.mainLogo)
        val mainTitle: TextView = itemView.findViewById(R.id.mainTitle)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.childItemRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemAdpater.ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item_listview, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val mainItem = datalist[position]
        holder.mainLogo.setImageResource(mainItem.mainLogo)
        holder.mainTitle.text = mainItem.mainTitle

        holder.childRecyclerView.setHasFixedSize(true)
        holder.childRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 3)
        val adapter = ChildAdpater(mainItem.mList)
        holder.childRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}