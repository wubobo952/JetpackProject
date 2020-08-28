package com.insane.jetpackproject.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.utils.BaseConfig
import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.jetpackproject.ui.login.LoginReposition
import com.insane.jetpackproject.ui.login.LoginViewModel


/**
 *Created by Insane
 */
class HotItemFragment : BaseFragment() {
    private var mIndex: Int? = 0
    private val mViewModel by lazy {
        parentFragment?.let {
            ViewModelProvider(
                it,
                BaseViewModelFactory(HomeReposition())
            ).get(HomeViewModel::class.java)
        }
    }

    companion object {
        fun newInstance(index: Int): HotItemFragment {
            val hotFragment = HotItemFragment()
            val bundle = Bundle()
            bundle.putInt(BaseConfig.PARAMETER, index)
            hotFragment.arguments = bundle
            return hotFragment
        }
    }

    override fun getLayout() = R.layout.fragment_hot_item

    override fun iniView() {
        mIndex = arguments?.getInt(BaseConfig.PARAMETER, 0)

    }

    override fun lazyInit() {
        when (mIndex) {
            0 -> mViewModel?.getHotBlog(1)
            1 -> mViewModel?. getHotBlog(2)
        }
    }
}