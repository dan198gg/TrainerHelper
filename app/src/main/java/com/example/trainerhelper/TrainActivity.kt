package com.example.trainerhelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrainActivity : AppCompatActivity() {
    lateinit var dbManager:MyDbManager
    lateinit var TrainName:ArrayList<String>
    lateinit var TrainImg:ArrayList<Byte>
    lateinit var TrainID: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)
        dbManager=MyDbManager(this)
        getRecycler()
        findViewById<Button>(R.id.buttonAddTrain).setOnClickListener {
            val intent1= Intent(this,AddTrainActivity::class.java)
            startActivity(intent1)
        }
    }
    fun getData() {
        dbManager.openDB()
        val cursor = dbManager.readDB()
        TrainName= ArrayList()
        TrainImg= ArrayList()
        TrainID= ArrayList()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                TrainName.add(cursor.getString(1))
                    TrainImg.add(cursor.getBlob(2))

                TrainID.add(cursor.getInt(0))
            }
            println()
        }
    }
    fun getRecycler() {
        getData()
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTrain)
        var customAdapter2 = CustomAdapter2(this,TrainImg,TrainName)
        recyclerView.adapter = customAdapter2
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
