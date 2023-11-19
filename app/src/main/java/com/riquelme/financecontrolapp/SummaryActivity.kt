package com.riquelme.financecontrolapp

import androidx.appcompat.app.AppCompatActivity
import com.riquelme.financecontrolapp.databinding.ActivitySummaryBinding
import android.os.Bundle

class SummaryActivity : AppCompatActivity() {

    lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}