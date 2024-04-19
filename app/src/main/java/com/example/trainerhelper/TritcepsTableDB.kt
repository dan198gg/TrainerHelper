package com.example.trainerhelper

import android.provider.BaseColumns

object TritcepsTableDB:BaseColumns {
    const val TABLE_NAME="tritcepsTable"
    const val COLUMN_NAME_TRAIN="NameTrain"
    const val COLUMN_IMAGE_TRAIN="ImgTrain"
    const val CREATE_TABLE2=
        "CREATE TABLE IF NOT EXISTS ${TABLE_NAME}("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY,"+
                "$COLUMN_IMAGE_TRAIN BLOB,"+
                "$COLUMN_NAME_TRAIN TEXT)"
}