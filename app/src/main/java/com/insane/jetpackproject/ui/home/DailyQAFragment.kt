package com.insane.jetpackproject.ui.home

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.insane.core.base.utils.BaseConfig
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R
import com.insane.jetpackproject.ui.WebViewActivity
import com.insane.jetpackproject.ui.adapter.DailyQAAdapter
import kotlinx.android.synthetic.main.fragment_daily_qa_layout.*
import kotlinx.android.synthetic.main.fragment_hot_blog_layout.*

/**
 *Created by Insane
 */
class DailyQAFragment : BaseFragment() {
    private val mAdapter: DailyQAAdapter by lazy {
        DailyQAAdapter()
    }

    companion object {
        fun newInstance(): DailyQAFragment {
            return DailyQAFragment()
        }
    }

    private val mViewModel by lazy {

        ViewModelProvider(
            this,
            BaseViewModelFactory(HomeReposition())
        ).get(HomeViewModel::class.java)

    }

    override fun iniView() {
        val manager = LinearLayoutManager(context)
        vDailyRv.apply {
            layoutManager = manager
            adapter = mAdapter
        }

        mAdapter.let {
            it.loadMoreModule.apply {
                setOnLoadMoreListener {
                    mViewModel.getDailyQA(false)
                }
            }
        }
        vDailyRefresh.setOnRefreshListener {
            mViewModel.getDailyQA(true)
        }


    }

    override fun getLayout() = R.layout.fragment_daily_qa_layout

    override fun lazyInit() {
        mViewModel.getDailyQA(true)
    }

    override fun showUi() {
        mViewModel.dailyDataLiveData.observe(this, Observer {
            if (it.datas.isEmpty()) {
                mAdapter.loadMoreModule.loadMoreEnd()
            } else {
                if (it.curPage == 0) {
                    mAdapter.setNewInstance(it.datas)
                    vDailyRefresh.isRefreshing = false
                } else {
                    mAdapter.addData(it.datas)
                    mAdapter.loadMoreModule.loadMoreComplete()
                }
            }
        })
    }
}