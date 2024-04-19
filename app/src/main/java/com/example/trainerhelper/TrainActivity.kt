package com.example.trainerhelper

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrainActivity : AppCompatActivity() {
    lateinit var dbManager: MyDbManager
    lateinit var TrainName: ArrayList<String>
    lateinit var TrainImg: ArrayList<Bitmap>
    lateinit var TrainID: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)
        dbManager = MyDbManager(this)

        getRecycler()
        findViewById<Button>(R.id.buttonAddTrain).setOnClickListener {
            val intent1 = Intent(this, AddTrainActivity::class.java)
            if(intent.getIntExtra("value", 1)==1){
                intent1.putExtra("value2",1)
            }
            else if(intent1.getIntExtra("value",1)==2){
                intent1.putExtra("value2",2)
            }
            startActivity(intent1)

        }
    }

    fun getData() {
        dbManager.openDB()
        val getInt = intent.getIntExtra("value",1)
        if (getInt == 1) {
            Log.i("getInteegeg", getInt.toString())
            val cursor = dbManager.readDB1()
            TrainName = ArrayList()
            TrainImg = ArrayList()
            TrainID = ArrayList()
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    TrainName.add(cursor.getString(2))
                    val imgByteArray = cursor.getBlob(1)
                    TrainImg.add(BitmapFactory.decodeByteArray(imgByteArray, 0, imgByteArray.size))
                    TrainID.add(cursor.getInt(0))
                }
            }
            if (getInt == 2) {
                Log.i("getInteegeg", getInt.toString())
                val cursor = dbManager.readDB2()
                TrainName = ArrayList()
                TrainImg = ArrayList()
                TrainID = ArrayList()
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        TrainName.add(cursor.getString(2))
                        val imgByteArray = cursor.getBlob(1)
                        TrainImg.add(
                            BitmapFactory.decodeByteArray(
                                imgByteArray,
                                0,
                                imgByteArray.size
                            )
                        )
                        TrainID.add(cursor.getInt(0))
                    }

                }
                println()
            }
        }

        }
    fun getRecycler() {
        getData()
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTrain)

        var customAdapter2 = CustomAdapter2(this, TrainImg, TrainName)
        recyclerView.adapter = customAdapter2
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
