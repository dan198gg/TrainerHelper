package com.example.trainerhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var muscules = arrayListOf<String>("Бицепс", "Трицепс","Плечи", "Грудные мышцы")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getRecycler()
    }

    fun getRecycler() {
        var recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        var customAdapter = CustomAdapter(this, muscules)
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}