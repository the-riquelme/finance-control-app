package com.riquelme.financecontrolapp

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import com.riquelme.financecontrolapp.databinding.ActivitySummaryBinding
import android.os.Bundle
import com.riquelme.financecontrolapp.repository.OrderRepository

class SummaryActivity : AppCompatActivity() {

    lateinit var binding: ActivitySummaryBinding
    lateinit var repository: OrderRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = OrderRepository(this)
        data()
    }

    @SuppressLint("SetTextI18n")
    private fun data() {
        try {
            val values: ContentValues = repository.getSummary()

            val received = values.getAsDouble("received") ?: 0.0
            val spent = values.getAsDouble("spent") ?: 0.0
            val total = values.getAsDouble("total") ?: 0.0

            binding.totalEntries.text = "R$ $received"
            binding.totalSpent.text = "R$ $spent"
            binding.totalAvailable.text = "R$ $total"
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}