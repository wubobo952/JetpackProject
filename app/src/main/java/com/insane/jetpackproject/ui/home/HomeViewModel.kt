package com.insane.jetpackproject.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.HotBlog
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class HomeViewModel(private var repos: HomeReposition) : BaseViewModel() {
    var bannerLiveData = MutableLiveData<List<Banner>>()
    var hotBlogLiveData = MutableLiveData<HotBlog>()

    fun getBanner() {
        lifecycleScope.launch {
            val banner = repos.getBanner()
            bannerLiveData.value = banner.data
        }
    }

    fun getHotBlog(page: Int) {
        lifecycleScope.launch {
            val hotBlog = repos.getHotBlog(page)
            hotBlogLiveData.value = hotBlog.data
            Log.e("TAG--", hotBlog.data.toString())
        }
    }

    override fun onCleared() {
        lifecycleScope.cancel()
    }

}