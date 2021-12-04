package com.kurilov.worldscillstrainingtasktwo

import android.app.Application
import android.content.Context

class mApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        lateinit  var appContext: Context
    }
}