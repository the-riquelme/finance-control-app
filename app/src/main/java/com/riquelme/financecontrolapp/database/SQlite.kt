package com.riquelme.financecontrolapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQlite(context: Context): SQLiteOpenHelper(context, DATABASE, null, VERSION) {

    companion object{
        private const val DATABASE: String = "finance_control_app.db"
        private const val VERSION: Int = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE orders(id integer primary key autoincrement, name text, price real, date integer, entryOrExit integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}