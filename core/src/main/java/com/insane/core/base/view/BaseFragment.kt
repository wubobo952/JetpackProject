package com.insane.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *Created by Insane
 * androidX 通过设置可见Fragment才会执行到 onResume 来进行懒加载
 */
abstract class BaseFragment : Fragment() {
    private var mView: View? = null
    private var isHasLoad = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mView == null) mView = inflater.inflate(getLayout(), container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniView()
    }

    abstract fun iniView()

    abstract fun getLayout(): Int

    override fun onResume() {
        super.onResume()
        if (!isHasLoad) {
            lazyInit()
            isHasLoad = true
        }
    }

    abstract fun lazyInit()
}