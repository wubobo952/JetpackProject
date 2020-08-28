package com.insane.jetpackproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.insane.core.base.view.BaseActivity
import com.insane.jetpackproject.ui.SecondFragment
import com.insane.jetpackproject.ui.adapter.MainVpAdapter
import com.insane.jetpackproject.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    private val mHomeTitle = arrayOf("首页", "体系")
    private var mFragments = mutableListOf<Fragment>()

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        mFragments.add(HomeFragment.newInstance())
        mFragments.add(SecondFragment.newInstance())

        vMainViewPager.adapter =MainVpAdapter(mFragments,mHomeTitle,supportFragmentManager,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vMainTab.setupWithViewPager(vMainViewPager)
    }

    override fun initData() {

    }

}