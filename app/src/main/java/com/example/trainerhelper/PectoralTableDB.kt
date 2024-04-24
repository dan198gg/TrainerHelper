package com.example.trainerhelper

import android.provider.BaseColumns

object PectoralTableDB:BaseColumns {
    const val TABLE_NAME="PectoralTable"
    const val COLUMN_NAME_TRAIN="NameTrain"
    const val COLUMN_IMAGE_TRAIN="ImgTrain"
    const val CREATE_TABLE4=
        "CREATE TABLE IF NOT EXISTS ${TABLE_NAME}("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY,"+
                "$COLUMN_IMAGE_TRAIN BLOB,"+
                "$COLUMN_NAME_TRAIN TEXT)"
}