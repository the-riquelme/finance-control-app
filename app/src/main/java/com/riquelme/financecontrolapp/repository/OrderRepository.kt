package com.riquelme.financecontrolapp.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.riquelme.financecontrolapp.database.SQlite
import com.riquelme.financecontrolapp.model.Order

class OrderRepository(var cotext: Context) {

    lateinit var database: SQLiteDatabase

    init {
        this.database = SQlite(cotext).writableDatabase
    }

    fun save(order: Order): Boolean {
        val values: ContentValues = ContentValues()

        values.put("name", order.name)
        values.put("price", order.price)
        values.put("date", order.date)
        values.put("entryOrExit", order.entryOrExit)

        return this.database.insert("orders", null, values) > 0
    }

    fun getSummary(): ContentValues {
        val summary = ContentValues()

        val spent = getAmountOrSpent(false)
        val received = getAmountOrSpent(true)

        summary.put("spent", spent)
        summary.put("received", received)
        summary.put("total", (received.toDouble() - spent.toDouble()).toString())

        return summary
    }

    private fun getAmountOrSpent(isReceived: Boolean): String {
        val entryValue = if (isReceived) 1 else 0
        val cursor = database.rawQuery("SELECT sum(price) FROM orders WHERE entryOrExit = ?", arrayOf(entryValue.toString()))

        var totalAmount = "0.00"

        cursor.use { cursor ->
            if (cursor.moveToFirst()) {
                totalAmount = cursor.getString(0) ?: "0.00"
            }
        }

        return totalAmount
    }


}