package com.example.trainerhelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.media.Image
import android.widget.Toast
import androidx.core.content.contentValuesOf
import java.io.ByteArrayOutputStream


class MyDbManager(var context: Context) {
        val myDbHelper = MyDbHelper(context)
        var db: SQLiteDatabase? = null

        fun openDB() {
            db = myDbHelper.writableDatabase
        }
        fun closeDB(){
        myDbHelper.close()
    }
    fun storeImg(imag:ModelClass, train: String){
        openDB()
        val bitmap:Bitmap=imag.img
        val byteArrayStream=ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayStream)
        val byteArray=byteArrayStream.toByteArray()
        val cv=ContentValues().apply {
            put(BicepsTableDB.COLUMN_IMAGE_TRAIN,byteArray)
            put(BicepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(BicepsTableDB.TABLE_NAME, null, cv)
        closeDB()
    }
    fun insertDb(img: Bitmap, train: String) {
        openDB()
        var convert=img.toString()
        val values = ContentValues().apply {
            put(BicepsTableDB.COLUMN_IMAGE_TRAIN,convert)
            put(BicepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(BicepsTableDB.TABLE_NAME, null, values)
        closeDB()
    }

    fun readDB(): Cursor? {
        var query: String = "SELECT * FROM ${BicepsTableDB.TABLE_NAME}"
        db = myDbHelper.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db?.rawQuery(query, null)
        }
        return cursor
    }

    fun updateDB(_id:String,
                 img: Image,
                 train: String):Int {
        var convert = img.toString()
        db = myDbHelper.writableDatabase
        var contentValues = ContentValues().apply {
            put(BicepsTableDB.COLUMN_IMAGE_TRAIN, convert)
            put(BicepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        var result=0
        result = db!!.update(BicepsTableDB.TABLE_NAME, contentValues, "_id=?", arrayOf(_id))
        if (result == -1) {
            Toast.makeText(context, "Fail!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "OK!", Toast.LENGTH_SHORT).show()
        }
        return result
    }

}