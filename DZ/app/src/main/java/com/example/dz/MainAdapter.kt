package com.example.dz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.constraintlayout.helper.widget.Layer
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val blocks: List<Blocks>):RecyclerView.Adapter<MainAdapter.MainViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tabl,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(blocks[position])
    }

    override fun getItemCount(): Int {
        return blocks.size
    }

    class MainViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        private val tv:TextView=itemView.findViewById(R.id.tabl_tv)
        fun bind(blocks:Blocks)
        {
            tv.text=blocks.number.toString()
            tv.setBackgroundColor(blocks.background)
        }
    }
}