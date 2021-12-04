package com.kurilov.worldscillstrainingtasktwo.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.kurilov.worldscillstrainingtasktwo.data.DataLoader
import com.kurilov.worldscillstrainingtasktwo.databinding.ActivityRecordBinding
import com.kurilov.worldscillstrainingtasktwo.ui.menu.MenuActivity
import com.squareup.picasso.Picasso

class RecordActivity : Activity() {

    private lateinit var binding: ActivityRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        intent.extras?.getInt("index")?.let { index->
            Picasso.get()
                .load(DataLoader.records[index].imageMenu)
                .into(binding.recordTitleImage)
            binding.recordTitleText.text = DataLoader.records[index].name
            Picasso.get()
                .load(DataLoader.records[index].imageRecord)
                .into(binding.recordImage)
            binding.recordDescription.text = DataLoader.records[index].description

        }

    }

}