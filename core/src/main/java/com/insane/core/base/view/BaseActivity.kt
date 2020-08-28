package com.insane.core.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *Created by Insane
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView()
        initData()
    }

    abstract fun getLayout(): Int

    abstract fun initView()

    open fun initData(){

     }
}