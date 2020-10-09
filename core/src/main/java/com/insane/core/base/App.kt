package com.insane.core.base

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
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

        fun isNetworkConnected(): Boolean {
            val mConnectivityManager = mApplication
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mNetworkInfo = mConnectivityManager.activeNetworkInfo
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable
            }
            return false
        }

    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
        SpUtil.init(this)
    }
}