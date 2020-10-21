package com.insane.jetpackproject

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.insane.core.base.kt.loadCircleImage
import com.insane.core.base.view.BaseActivity
import com.insane.jetpackproject.ui.SecondFragment
import com.insane.jetpackproject.ui.adapter.MainVpAdapter
import com.insane.jetpackproject.ui.home.DailyQAFragment
import com.insane.jetpackproject.ui.home.HomeFragment
import com.insane.jetpackproject.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    private val mHomeTitle = arrayOf("首页", "体系","问答")
    private var mFragments = mutableListOf<Fragment>()

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        mFragments.add(HomeFragment.newInstance())
        mFragments.add(SecondFragment.newInstance())
        mFragments.add(DailyQAFragment.newInstance())

        vMainViewPager.adapter = MainVpAdapter(
            mFragments,
            mHomeTitle,
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        vMainTab.setupWithViewPager(vMainViewPager)
    }

    override fun initData() {
        vMainUser.loadCircleImage("https://www.wanandroid.com/blogimgs/bb0747bd-f59f-4733-8d29-0735502f0c6c.png")
        vMainUser.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

}