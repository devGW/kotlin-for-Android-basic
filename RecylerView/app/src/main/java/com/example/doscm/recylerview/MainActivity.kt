package com.example.doscm.recylerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            var layout = LayoutInflater.from(p0.context!!).inflate(R.layout.item_layout,null)

        }

        override fun getItemCount(): Int {
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        }

    }
}
