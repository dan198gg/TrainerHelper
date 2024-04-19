package com.example.trainerhelper

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.app.ActivityCompat

class AddTrainActivity : AppCompatActivity() {
    lateinit var dbManager:MyDbManager
    var pickedPhoto: Uri?=null
    lateinit var TrainName:ArrayList<String>
    lateinit var TrainImg:ArrayList<Bitmap?>
    lateinit var TrainID: ArrayList<Int>
    var pickedBitMap:Bitmap?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_train)

        dbManager= MyDbManager(this)
        getData()
        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            if(intent.getIntExtra("value2",1)==1) {
                dbManager.storeImg1(
                    ModelClass(
                        findViewById<EditText>(R.id.editNameTrain).text.toString(),
                        pickedBitMap!!
                    ), findViewById<EditText>(R.id.editNameTrain).text.toString()
                )
                val intent1 = Intent(this, TrainActivity::class.java)
                startActivity(intent1)
                finish()
            }
            if(intent.getIntExtra("value2",1)==2) {
                dbManager.storeImg2(
                    ModelClass(
                        findViewById<EditText>(R.id.editNameTrain).text.toString(),
                        pickedBitMap!!
                    ), findViewById<EditText>(R.id.editNameTrain).text.toString()
                )
                val intent1 = Intent(this, TrainActivity::class.java)
                startActivity(intent1)
                finish()
            }
        }
    }
//    fun chooseImage(view: View){
//        try {
//            var intent=Intent()
//            intent.type="image/*"
//            intent.type=Intent.ACTION_GET_CONTENT
//            startActivityForResult(intent,100)
//        }catch (e:Exception){
//            Toast.makeText(this, "error 404"+e.message, Toast.LENGTH_SHORT).show()
//        }
//    }
    fun pickedPhoto(view:View) {
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
        }else{
            val galleryIntext=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntext,2)
        }
    }
    fun getData() {
        dbManager.openDB()
        val getInt = intent.getIntExtra("value", 1)
        if (getInt == 1) {
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
            } else if (getInt == 2) {
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
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.size>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            val galleryIntext=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntext,2)
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == 2 && requestCode == Activity.RESULT_OK && data!=null){
            pickedPhoto=data?.data
            if (Build.VERSION.SDK_INT>=28){
                val source=ImageDecoder.createSource(this.contentResolver,pickedPhoto!!)
                pickedBitMap=ImageDecoder.decodeBitmap(source)
                findViewById<ImageView>(R.id.imageViewTrainAdd).setImageBitmap(pickedBitMap)
            }else{
                pickedBitMap=MediaStore.Images.Media.getBitmap(this.contentResolver,pickedPhoto)
                findViewById<ImageView>(R.id.imageViewTrainAdd).setImageBitmap(pickedBitMap)

//            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}