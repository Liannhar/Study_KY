package com.example.dz

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity: AppCompatActivity()
{
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blocks = CreateList().toMutableList()

        val rv:RecyclerView = findViewById(R.id.fragment_main_rv)
        val adapter = MainAdapter(blocks)
        val GridLayoutManager = GridLayoutManager(this,3,RecyclerView.VERTICAL,false)
        rv.layoutManager = GridLayoutManager
        rv.adapter=adapter
        val fab:ExtendedFloatingActionButton = findViewById(R.id.fragment_main_ab)
        fab.setOnClickListener()
        {
            if (i%2==0) {
                blocks.add(Blocks(i,Color.RED) )
            }
            else
            {
                blocks.add(Blocks(i,Color.BLUE) )
            }

            if(getScreenOrientation()==4) rv.layoutManager = GridLayoutManager(this,4,RecyclerView.VERTICAL,false)
            else  rv.layoutManager = GridLayoutManager(this,3,RecyclerView.VERTICAL,false)
            adapter.notifyDataSetChanged()
            i++
        }

    }
    private fun CreateList(): List<Blocks>
    {
        return  emptyList<Blocks>()
    }
    private fun getScreenOrientation(): Int {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 3
            Configuration.ORIENTATION_LANDSCAPE -> 4
            else -> 0
        }
    }
}