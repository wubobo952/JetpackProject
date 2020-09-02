package com.insane.jetpackproject.ui

import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R

/**
 *Created by Insane
 */
class SecondFragment : BaseFragment() {


    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun getLayout() = R.layout.fragment_second_layout

    override fun iniView() {
    }

    override fun lazyInit() {
    }

    override fun showUi() {

    }

}