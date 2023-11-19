package com.riquelme.financecontrolapp

import androidx.appcompat.app.AppCompatActivity
import com.riquelme.financecontrolapp.databinding.ActivityHomeBinding
import android.os.Bundle


class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}