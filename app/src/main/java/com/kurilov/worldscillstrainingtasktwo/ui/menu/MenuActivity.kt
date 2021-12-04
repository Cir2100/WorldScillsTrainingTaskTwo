package com.kurilov.worldscillstrainingtasktwo.ui.menu

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kurilov.worldscillstrainingtasktwo.data.DataLoader
import com.kurilov.worldscillstrainingtasktwo.databinding.ActivityMenuBinding

class MenuActivity : Activity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.menuList.layoutManager = LinearLayoutManager(this)

        adapter = MenuAdapter(DataLoader.getMenu())
        binding.menuList.adapter = adapter
    }
}