package com.kurilov.worldscillstrainingtasktwo.ui.menu

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kurilov.worldscillstrainingtasktwo.data.DataLoader
import com.kurilov.worldscillstrainingtasktwo.data.Record
import com.kurilov.worldscillstrainingtasktwo.databinding.ActivityMenuBinding
import com.kurilov.worldscillstrainingtasktwo.ui.RecordActivity

class MenuActivity : Activity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var adapter: MenuAdapter
    private val menuItemClickListener = MenuItemClickListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.menuList.layoutManager = LinearLayoutManager(this)
        adapter = MenuAdapter(DataLoader.records, menuItemClickListener)
        binding.menuList.adapter = adapter
    }

    inner class MenuItemClickListener {

        fun onClickPairItem(index : Int) {
            val recordIntent = Intent(this@MenuActivity, RecordActivity::class.java)
            recordIntent.putExtra("index", index)
            startActivity(recordIntent)
        }
    }
}