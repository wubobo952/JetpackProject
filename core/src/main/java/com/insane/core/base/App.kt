package com.insane.core.base

import android.app.Application
import com.insane.core.base.utils.SpUtil

/**
 *Created by Insane
 */
class App : Application() {

    companion object {
        lateinit var mApplication: Application

        @JvmStatic
        fun getInstance(): App {
            return mApplication as App
        }
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
        SpUtil.init(this)
    }
}