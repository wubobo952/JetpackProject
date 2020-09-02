package com.insane.jetpackproject.ui.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.core.base.view.BaseFragment
import com.insane.jetpackproject.R
import com.insane.jetpackproject.ui.adapter.HotProjectAdapter
import kotlinx.android.synthetic.main.fragment_hot_project_layout.*

/**
 *Created by Insane
 */
class HotProjectFragment : BaseFragment() {
    private val mAdapter by lazy {
        HotProjectAdapter()
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
        fun newInstance(): HotProjectFragment {
            return HotProjectFragment()
        }
    }

    override fun iniView() {
        val manager = LinearLayoutManager(context)

        vHotProjectRv.apply {
            layoutManager = manager
            adapter = mAdapter
        }

    }

    override fun showUi() {
        mViewModel?.hotProjectLiveData?.observe(this, Observer {
            mAdapter.setNewInstance(it)
        })
    }

    override fun getLayout() = R.layout.fragment_hot_project_layout

    override fun lazyInit() {
        mViewModel?.getHotProject()
    }
}