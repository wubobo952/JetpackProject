package com.insane.jetpackproject.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
import com.insane.core.network.RequestCallback
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.HotBlog
import com.insane.jetpackproject.bean.home.HotProjectTree
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class HomeViewModel(private var repos: HomeReposition) : BaseViewModel() {
    var bannerLiveData = MutableLiveData<List<Banner>>()
    var hotBlogLiveData = MutableLiveData<HotBlog>()
    var hotProjectLiveData = MutableLiveData<MutableList<HotProjectTree>>()

    fun getBanner() {
        lifecycleScope.launch {
            repos.getBanner()
                .collect{
                    bannerLiveData.value=it
                }
        }
    }

    fun getHotBlog(page: Int) {
        lifecycleScope.launch {
            repos.getHotBlog(page)
                .collect {
                    hotBlogLiveData.value=it
                }
        }
    }

    fun getHotProject() {
        lifecycleScope.launch {
            repos.getProject()
                .collect {
                    hotProjectLiveData.value=it
                }
        }
    }
}