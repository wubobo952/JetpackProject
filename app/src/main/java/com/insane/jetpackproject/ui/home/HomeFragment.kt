package com.insane.jetpackproject.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R
import com.insane.jetpackproject.ui.adapter.MainVpAdapter
import kotlinx.android.synthetic.main.fragment_home_layout.*

/**
 *Created by Insane
 */
class HomeFragment : BaseFragment() {
    private val mTitles = arrayOf("热门文章", "热门项目")
    private val mFragments = mutableListOf<Fragment>()

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayout() = R.layout.fragment_home_layout

    override fun iniView() {
        for (i in mTitles.indices) {
            mFragments.add(HotItemFragment.newInstance(i))
        }
        vHomeViewPager.adapter =
            MainVpAdapter(
                mFragments,
                mTitles,
                childFragmentManager,
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
            )
        vHomeTab.setupWithViewPager(vHomeViewPager)
    }

    override fun lazyInit() {
    }
}