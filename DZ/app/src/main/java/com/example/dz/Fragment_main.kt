package com.example.dz

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton


class FragmentMain : Fragment() {

    private var i=0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blocks = createList().toMutableList()
        val rv: RecyclerView = view.findViewById(R.id.fragment_main_rv)
        val adapter = MainAdapter(blocks)
        val col = getScreenOrientation()
        val gridLayoutManager = GridLayoutManager(view.context,col, RecyclerView.VERTICAL,false)
        rv.layoutManager = gridLayoutManager
        rv.adapter=adapter

        if (savedInstanceState != null) {
            i = savedInstanceState.getInt("counter", 0)

            for(j in 0..i)
            {
                addBlock(j,blocks)
            }
        }

        val fab: ExtendedFloatingActionButton = view.findViewById(R.id.fragment_main_ab)
        fab.setOnClickListener()
        {
            addBlock(i,blocks)
                adapter.notifyDataSetChanged()
            i++
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", i)
    }


    private fun createList(): List<Blocks>
    {
        return  emptyList()
    }

    private fun getScreenOrientation(): Int {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 3
            Configuration.ORIENTATION_LANDSCAPE -> 4
            else -> 0
        }
    }

    private fun addBlock(i:Int,blocks: MutableList<Blocks>)
    {
        if (i%2==0) {
            blocks.add(Blocks(i, Color.RED) )
        }
        else
        {
            blocks.add(Blocks(i, Color.BLUE) )
        }
    }


}