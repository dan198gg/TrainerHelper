package com.example.trainerhelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.media.Image
import android.widget.Toast
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
    fun storeImg1(imag:ModelClass, train: String){
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
    fun insertDb1(img: Bitmap, train: String) {
        openDB()
        var convert=img.toString()
        val values = ContentValues().apply {
            put(BicepsTableDB.COLUMN_IMAGE_TRAIN,convert)
            put(BicepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(BicepsTableDB.TABLE_NAME, null, values)
        closeDB()
    }

    fun readDB1(): Cursor? {
        var query: String = "SELECT * FROM ${BicepsTableDB.TABLE_NAME}"
        db = myDbHelper.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db?.rawQuery(query, null)
        }
        return cursor
    }

    fun updateDB1(_id:String,
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
    fun storeImg2(imag:ModelClass, train: String){
        openDB()
        val bitmap:Bitmap=imag.img
        val byteArrayStream=ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayStream)
        val byteArray=byteArrayStream.toByteArray()
        val cv=ContentValues().apply {
            put(TritcepsTableDB.COLUMN_IMAGE_TRAIN,byteArray)
            put(TritcepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(TritcepsTableDB.TABLE_NAME, null, cv)
        closeDB()
    }
    fun insertDb2(img: Bitmap, train: String) {
        openDB()
        var convert=img.toString()
        val values = ContentValues().apply {
            put(TritcepsTableDB.COLUMN_IMAGE_TRAIN,convert)
            put(TritcepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(TritcepsTableDB.TABLE_NAME, null, values)
        closeDB()
    }

    fun readDB2(): Cursor? {
        openDB()
        var query: String = "SELECT * FROM ${TritcepsTableDB.TABLE_NAME}"
        db = myDbHelper.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db?.rawQuery(query, null)
        }
        return cursor
    }

    fun updateDB2(_id:String,
                  img: Image,
                  train: String):Int {
        var convert = img.toString()
        db = myDbHelper.writableDatabase
        var contentValues = ContentValues().apply {
            put(TritcepsTableDB.COLUMN_IMAGE_TRAIN, convert)
            put(TritcepsTableDB.COLUMN_NAME_TRAIN,train)
        }
        var result=0
        result = db!!.update(TritcepsTableDB.TABLE_NAME, contentValues, "_id=?", arrayOf(_id))
        if (result == -1) {
            Toast.makeText(context, "Fail!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "OK!", Toast.LENGTH_SHORT).show()
        }
        return result
    }
    fun storeImg3(imag:ModelClass, train: String){
        openDB()
        val bitmap:Bitmap=imag.img
        val byteArrayStream=ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayStream)
        val byteArray=byteArrayStream.toByteArray()
        val cv=ContentValues().apply {
            put(ShouldersTableDB.COLUMN_IMAGE_TRAIN,byteArray)
            put(ShouldersTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(ShouldersTableDB.TABLE_NAME, null, cv)
        closeDB()
    }
    fun insertDb3(img: Bitmap, train: String) {
        openDB()
        var convert=img.toString()
        val values = ContentValues().apply {
            put(ShouldersTableDB.COLUMN_IMAGE_TRAIN,convert)
            put(ShouldersTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(ShouldersTableDB.TABLE_NAME, null, values)
        closeDB()
    }

    fun readDB3(): Cursor? {

        var query: String = "SELECT * FROM ${ShouldersTableDB.TABLE_NAME}"
        db = myDbHelper.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db?.rawQuery(query, null)
        }
        return cursor
    }

    fun updateDB3(_id:String,
                  img: Image,
                  train: String):Int {
        var convert = img.toString()
        db = myDbHelper.writableDatabase
        var contentValues = ContentValues().apply {
            put(ShouldersTableDB.COLUMN_IMAGE_TRAIN, convert)
            put(ShouldersTableDB.COLUMN_NAME_TRAIN,train)
        }
        var result=0
        result = db!!.update(ShouldersTableDB.TABLE_NAME, contentValues, "_id=?", arrayOf(_id))
        if (result == -1) {
            Toast.makeText(context, "Fail!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "OK!", Toast.LENGTH_SHORT).show()
        }
        return result
    } fun storeImg4(imag:ModelClass, train: String){
        openDB()
        val bitmap:Bitmap=imag.img
        val byteArrayStream=ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayStream)
        val byteArray=byteArrayStream.toByteArray()
        val cv=ContentValues().apply {
            put(PectoralTableDB.COLUMN_IMAGE_TRAIN,byteArray)
            put(PectoralTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(PectoralTableDB.TABLE_NAME, null, cv)
        closeDB()
    }
    fun insertDb4(img: Bitmap, train: String) {
        openDB()
        var convert=img.toString()
        val values = ContentValues().apply {
            put(PectoralTableDB.COLUMN_IMAGE_TRAIN,convert)
            put(PectoralTableDB.COLUMN_NAME_TRAIN,train)
        }
        db?.insert(PectoralTableDB.TABLE_NAME, null, values)
        closeDB()
    }

    fun readDB4(): Cursor? {

        var query: String = "SELECT * FROM ${PectoralTableDB.TABLE_NAME}"
        db = myDbHelper.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db?.rawQuery(query, null)
        }
        return cursor
    }

    fun updateDB4(_id:String,
                  img: Image,
                  train: String):Int {
        var convert = img.toString()
        db = myDbHelper.writableDatabase
        var contentValues = ContentValues().apply {
            put(PectoralTableDB.COLUMN_IMAGE_TRAIN, convert)
            put(PectoralTableDB.COLUMN_NAME_TRAIN,train)
        }
        var result=0
        result = db!!.update(PectoralTableDB.TABLE_NAME, contentValues, "_id=?", arrayOf(_id))
        if (result == -1) {
            Toast.makeText(context, "Fail!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "OK!", Toast.LENGTH_SHORT).show()
        }
        return result
    }

}