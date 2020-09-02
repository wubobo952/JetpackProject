package com.insane.jetpackproject.ui.home

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.insane.core.base.kt.loadImageUrl
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.ui.adapter.MainVpAdapter
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_home_layout.*

/**
 *Created by Insane
 */
class HomeFragment : BaseFragment() {
    private val mTitles = arrayOf("热门文章", "热门项目")
    private val mFragments = mutableListOf<Fragment>()
    private val mViewModel by lazy {
        ViewModelProvider(
            this,
            BaseViewModelFactory(HomeReposition())
        ).get(HomeViewModel::class.java)

    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayout() = R.layout.fragment_home_layout

    override fun iniView() {
        mFragments.add(HotBlogFragment.newInstance())
        mFragments.add(HotProjectFragment.newInstance())

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
        mViewModel.getBanner()
    }

    override fun showUi() {
        //banner
        mViewModel.bannerLiveData.observe(this, Observer {
            vBanner.addBannerLifecycleObserver(this)
                .setIndicator(CircleIndicator(context))
                .setAdapter(object :
                    BannerImageAdapter<Banner>(it) {
                    override fun onBindView(
                        holder: BannerImageHolder,
                        data: Banner,
                        position: Int,
                        size: Int
                    ) {
                        data.imagePath?.apply { holder.imageView.loadImageUrl(this) }
                    }
                })
        })
    }
}