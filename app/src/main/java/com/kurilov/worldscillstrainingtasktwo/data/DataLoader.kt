package com.kurilov.worldscillstrainingtasktwo.data

import android.content.res.TypedArray
import android.util.Log
import com.kurilov.worldscillstrainingtasktwo.R
import com.kurilov.worldscillstrainingtasktwo.mApp
import java.lang.Integer.min

object DataLoader {

    private val res = mApp.appContext.resources

    lateinit var records : List<Record>

    init {
        getRecords()
    }

    private fun getRecords() {
        val _records = mutableListOf<Record>()
        val menuImages = res.obtainTypedArray(R.array.menu_images)
        val menuNames = res.getStringArray(R.array.menu_names)
        val recordImages = res.obtainTypedArray(R.array.record_images)
        val recordDescriptions = res.getStringArray(R.array.record_description)

        for (i in 0..min(menuNames.size - 1, menuImages.length() - 1))
            _records.add(
                Record(
                    name = menuNames[i],
                    imageMenu = menuImages.getResourceId(i, 0),
                    imageRecord = recordImages.getResourceId(i, 0),
                    description = recordDescriptions[i])
            )
        menuImages.recycle()
        recordImages.recycle()
        records = _records
    }
}