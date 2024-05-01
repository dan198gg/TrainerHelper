package com.example.trainerhelper

import android.content.ContentValues
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import kotlin.math.absoluteValue


class LogoActivity : AppCompatActivity(),Animation.AnimationListener {
    lateinit var myDbManager: MyDbManager
    lateinit var TrainName: ArrayList<String>
    lateinit var TrainImg: ArrayList<Bitmap>
    lateinit var TrainID: ArrayList<Int>
    lateinit var TrainName2: ArrayList<String>
    lateinit var TrainImg2: ArrayList<Bitmap>
    lateinit var TrainID2: ArrayList<Int>
    lateinit var TrainName3: ArrayList<String>
    lateinit var TrainImg3: ArrayList<Bitmap>
    lateinit var TrainID3: ArrayList<Int>
    lateinit var TrainName4: ArrayList<String>
    lateinit var TrainImg4: ArrayList<Bitmap>
    lateinit var TrainID4: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        myDbManager=MyDbManager(this)
        getData()
        if(TrainName4.size>0 || TrainName3.size>0 || TrainName2.size>0 || TrainName.size>0) {
        }
        else {
            imgToBit()
            println()
        }
        var img=findViewById<ImageView>(R.id.imageLogo)
        var anim=AnimationUtils.loadAnimation(this,R.anim.fading_in)
        anim.setAnimationListener(this)
        img.startAnimation(anim)
    }
     fun imgToBit(){
         var pickedBitMap:Bitmap?=null
         var pickedBitmap2:Bitmap?=null
         var pickedBitmap3:Bitmap?=null
         var pickedBitmap4:Bitmap?=null
         val source= ImageDecoder.createSource(resources,R.drawable.otdjimania)
         pickedBitMap= ImageDecoder.decodeBitmap(source)
         val source2= ImageDecoder.createSource(resources,R.drawable.ganteli)
         pickedBitmap2= ImageDecoder.decodeBitmap(source2)
         val source3= ImageDecoder.createSource(resources,R.drawable.ganteli2)
         pickedBitmap3= ImageDecoder.decodeBitmap(source3)
         val source4= ImageDecoder.createSource(resources,R.drawable.trip)
         pickedBitmap4= ImageDecoder.decodeBitmap(source4)
         downloadImg(ModelClass(R.drawable.trip.toString(),pickedBitmap4),"Отжимания на трицепс",TritcepsTableDB.TABLE_NAME)

         downloadImg(ModelClass(R.drawable.ganteli.toString(),pickedBitmap2),"Подъем гантель на бицепс",BicepsTableDB.TABLE_NAME)
         downloadImg(ModelClass(R.drawable.otdjimania.toString(),pickedBitMap),"Отжимания",PectoralTableDB.TABLE_NAME)
         downloadImg(ModelClass(R.drawable.ganteli2.toString(),pickedBitmap3),"Подъем гантель на плечи",ShouldersTableDB.TABLE_NAME)
         myDbManager.closeDB()

     }
    fun downloadImg(imag:ModelClass,train:String,tableName:String) {

        val db=myDbManager.db
        myDbManager.openDB()
        val bitmap:Bitmap=imag.img
        val byteArrayStream=ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayStream)
        val byteArray=byteArrayStream.toByteArray()

        val cv=ContentValues().apply {
            if (tableName==PectoralTableDB.TABLE_NAME){
            put(PectoralTableDB.COLUMN_IMAGE_TRAIN, byteArray)
            put(PectoralTableDB.COLUMN_NAME_TRAIN, train)
        }
            if (tableName==BicepsTableDB.TABLE_NAME){
                put(BicepsTableDB.COLUMN_IMAGE_TRAIN,byteArray)
                put(BicepsTableDB.COLUMN_NAME_TRAIN,train)
            }
            if (tableName==TritcepsTableDB.TABLE_NAME){
                put(TritcepsTableDB.COLUMN_IMAGE_TRAIN,byteArray)
                put(TritcepsTableDB.COLUMN_NAME_TRAIN,train)
            }
            if (tableName==ShouldersTableDB.TABLE_NAME){
                put(ShouldersTableDB.COLUMN_IMAGE_TRAIN,byteArray)
                put(ShouldersTableDB.COLUMN_NAME_TRAIN,train)
            }
    }
        db?.insert(tableName, null, cv)

    }


    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        var intent1=Intent(this,MainActivity::class.java)
        startActivity(intent1)
        finish()
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }

    fun getData(){
        val cursor = myDbManager.readDB1()
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
        println()
        val cursor2 = myDbManager.readDB2()
        TrainName2 = ArrayList()
        TrainImg2 = ArrayList()
        TrainID2 = ArrayList()
        if (cursor != null) {
            while (cursor2!!.moveToNext()) {
                TrainName2.add(cursor2.getString(2))
                val imgByteArray = cursor2.getBlob(1)
                TrainImg2.add(BitmapFactory.decodeByteArray(imgByteArray, 0, imgByteArray.size))
                TrainID2.add(cursor2.getInt(0))
            }
        }
        println()
        val cursor3 = myDbManager.readDB3()
        TrainName3 = ArrayList()
        TrainImg3 = ArrayList()
        TrainID3 = ArrayList()
        if (cursor != null) {
            while (cursor3!!.moveToNext()) {
                TrainName3.add(cursor3.getString(2))
                val imgByteArray = cursor3.getBlob(1)
                TrainImg3.add(BitmapFactory.decodeByteArray(imgByteArray, 0, imgByteArray.size))
                TrainID3.add(cursor3.getInt(0))
            }
        }
        println()
        val cursor4 = myDbManager.readDB4()
        TrainName4 = ArrayList()
        TrainImg4 = ArrayList()
        TrainID4 = ArrayList()
        if (cursor != null) {
            while (cursor4!!.moveToNext()) {
                TrainName4.add(cursor4.getString(2))
                val imgByteArray = cursor4.getBlob(1)
                TrainImg4.add(BitmapFactory.decodeByteArray(imgByteArray, 0, imgByteArray.size))
                TrainID4.add(cursor4.getInt(0))
            }
        }
        println()
    }
    }
