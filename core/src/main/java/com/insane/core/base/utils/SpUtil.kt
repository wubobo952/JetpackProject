package com.insane.core.base.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences


/**
 *Created by Insane
 */
class SpUtil constructor(context: Context) {

    companion object {
        private var spUtils: SpUtil? = null
        private var sp: SharedPreferences? = null
        private const val PREF_NAME = "wan_android"


        @JvmStatic
        fun init(context: Context) {
            if (spUtils == null) {
                synchronized(SpUtil::class.java) {
                    if (spUtils == null) spUtils = SpUtil(context)
                }
            }
            sp = context.getSharedPreferences(
                PREF_NAME, Activity.MODE_PRIVATE
            )
        }

        @JvmStatic
        fun put(key: String, value: Any) {
            sp?.let {
                when (value) {
                    is Float -> it.edit().putFloat(key, value).apply()
                    is Int -> it.edit().putInt(key, value).apply()
                    is Boolean -> it.edit().putBoolean(key, value).apply()
                    else -> it.edit().putString(key, value.toString()).apply()
                }
            }
        }


        @JvmStatic
        fun putString(key: String, value: String) {
            sp?.apply {
                edit().putString(key, value).apply()
            }
        }

        @JvmStatic
        fun get(key: String, defaultValue: Any?): Any? {
            sp?.let {
                when (defaultValue) {
                    is Float -> it.getFloat(key, defaultValue)
                    is Int -> it.getInt(key, defaultValue)
                    is Boolean -> it.getBoolean(key, defaultValue)
                    else -> it.getString(key, defaultValue.toString())
                }
            }
            return null
        }

        @JvmStatic
        fun getString(key: String, defaultValue: String?): String? {
            sp?.let {
                return it.getString(key, defaultValue)
            }
            return null
        }

        fun contains(key: String): Boolean {
            sp?.let {
                return it.contains(key)
            }
            return false
        }
    }

}