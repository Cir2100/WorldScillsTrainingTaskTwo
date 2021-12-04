package com.kurilov.worldscillstrainingtasktwo.data

import android.content.res.TypedArray
import com.kurilov.worldscillstrainingtasktwo.R
import com.kurilov.worldscillstrainingtasktwo.mApp
import java.lang.Integer.min

object DataLoader {

    val res = mApp.appContext.resources

    fun getMenu() : List<MenuItem> {
        val menu = mutableListOf<MenuItem>()
        val menuImages : TypedArray = res.obtainTypedArray(R.array.menu_images)
        val menuNames = res.getStringArray(R.array.menu_names)
        for (i in 0..min(menuNames.size - 1, menuImages.length() - 1))
            menu.add(MenuItem(
                name = menuNames[i],
                image = menuImages.getResourceId(i, 0)))
        menuImages.recycle()
        return menu

    }


}