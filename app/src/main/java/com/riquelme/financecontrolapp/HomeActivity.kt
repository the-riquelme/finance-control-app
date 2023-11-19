package com.riquelme.financecontrolapp

import androidx.appcompat.app.AppCompatActivity
import android.view.View.OnClickListener
import com.riquelme.financecontrolapp.databinding.ActivityHomeBinding
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.riquelme.financecontrolapp.model.Order
import com.riquelme.financecontrolapp.repository.OrderRepository

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var repository: OrderRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = OrderRepository(this)
        setClickEvents()
    }

    private fun setClickEvents() {
        binding.registerBtn.setOnClickListener { registerOrder() }
        binding.listBtn.setOnClickListener { summary() }
    }

    private fun registerOrder() {
        val name = binding.productValue.text.toString()
        val price = binding.valueValue.text.toString().toDouble()
        val date = binding.date.text.toString()

        var entryOrOut = 0

        if (binding.entry.isChecked) {
            entryOrOut = 1
        } else if (binding.out.isChecked) {
            entryOrOut = 0
        }

        val order = Order(name, price, date, entryOrOut)
        repository.save(order)

        binding.productValue.text.clear()
        binding.valueValue.text.clear()
        binding.date.text.clear()
        binding.entry.isChecked = false
        binding.out.isChecked = false

        summary()
    }

    private fun summary() {
        val listIntent = Intent(baseContext, SummaryActivity::class.java)
        startActivity(listIntent)
    }

}