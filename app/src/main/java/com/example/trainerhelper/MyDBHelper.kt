package com.example.trainerhelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context): SQLiteOpenHelper(context,MyDBInfo.DB_NAME,null,MyDBInfo.DB_VER) {
    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL(BicepsTableDB.CREATE_TABLE1)
            db.execSQL(TritcepsTableDB.CREATE_TABLE2)
            db.execSQL(ShouldersTableDB.CREATE_TABLE3)
            db.execSQL(PectoralTableDB.CREATE_TABLE4)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}