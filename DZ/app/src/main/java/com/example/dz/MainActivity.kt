package com.example.dz

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blocks = CreateList().toMutableList()
        var i=0

        val rv:RecyclerView = findViewById(R.id.activity_main_rv)
        val adapter = MainAdapter(blocks)
        rv.adapter=adapter
        rv.layoutManager=LinearLayoutManager(this)
        val fab:ExtendedFloatingActionButton = findViewById(R.id.activity_main_ab)
        fab.setOnClickListener()
        {
            if (i%2==0) blocks.add(Blocks(i,Color.RED) )
            else blocks.add(Blocks(i,Color.BLUE) )
            adapter.notifyDataSetChanged()
            i++
        }

    }
    private fun CreateList(): List<Blocks>
    {
        return  emptyList<Blocks>()
    }
}