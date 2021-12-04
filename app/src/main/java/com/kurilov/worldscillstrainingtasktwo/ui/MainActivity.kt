package com.kurilov.worldscillstrainingtasktwo.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.kurilov.worldscillstrainingtasktwo.databinding.ActivityMainBinding
import com.kurilov.worldscillstrainingtasktwo.ui.menu.MenuActivity

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.nextButton.setOnClickListener {
            val menuActivityIntent = Intent(this, MenuActivity::class.java)
            startActivity(menuActivityIntent)
        }
    }
}