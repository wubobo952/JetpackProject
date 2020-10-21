package com.insane.core.base.utils

import android.widget.Toast
import androidx.annotation.StringRes
import com.insane.core.base.App

/**
 *Created by Insane
 */
object ToastUtil {
    fun showToast(content: String) {
        Toast.makeText(App.mApplication, content, Toast.LENGTH_LONG).show()
    }

    fun showToast(@StringRes strResID: Int) {
        showToast(App.mApplication.getString(strResID))
    }
}