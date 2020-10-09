package com.insane.jetpackproject.ui.home

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.insane.core.base.utils.BaseConfig
import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.jetpackproject.ui.WebViewActivity
import com.insane.jetpackproject.ui.adapter.HotBlogAdapter
import kotlinx.android.synthetic.main.fragment_hot_blog_layout.*


/**
 *Created by Insane
 */
class HotBlogFragment : BaseFragment() {
    private var mPage: Int = 0
    private val mAdapter by lazy {
        HotBlogAdapter()
    }
    private val mViewModel by lazy {
        parentFragment?.let {
            ViewModelProvider(
                it,
                BaseViewModelFactory(HomeReposition())
            ).get(HomeViewModel::class.java)
        }
    }

    companion object {
        fun newInstance(): HotBlogFragment {
            return HotBlogFragment()
        }
    }

    override fun getLayout() = R.layout.fragment_hot_blog_layout

    override fun iniView() {
        val manager = LinearLayoutManager(context)
        vHotItemRv.apply {
            layoutManager = manager
            adapter = mAdapter
        }


        mAdapter.loadMoreModule.apply {
            setOnLoadMoreListener {
                loadMoreComplete()
                mViewModel?.getHotBlog(++mPage)
            }
        }

        mAdapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra(BaseConfig.PARAMETER, mAdapter.getItem(position).link)
            startActivity(intent)
        }

    }

    override fun showUi() {
        mViewModel?.hotBlogLiveData?.observe(this, Observer {
            if (it.datas.isEmpty()) {
                mAdapter.loadMoreModule.loadMoreEnd()
            } else {
                mAdapter.addData(it.datas)
            }
        })
    }


    override fun lazyInit() {
        mViewModel?.getHotBlog(mPage)
    }
}