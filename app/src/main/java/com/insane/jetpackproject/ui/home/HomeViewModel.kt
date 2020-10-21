package com.insane.jetpackproject.ui.home

import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.DailyQA
import com.insane.jetpackproject.bean.home.HotBlog
import com.insane.jetpackproject.bean.home.HotProjectTree
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class HomeViewModel(private var repos: HomeReposition) : BaseViewModel() {
    private var hotBlogPage = 0
    private var dailyQAPage = 0
    var bannerLiveData = MutableLiveData<List<Banner>>()
    var hotBlogLiveData = MutableLiveData<HotBlog>()
    var hotProjectLiveData = MutableLiveData<MutableList<HotProjectTree>>()
    var dailyDataLiveData = MutableLiveData<DailyQA>()

    //首页banner
    fun getBanner() {
        lifecycleScope.launch {
            repos.getBanner()
                .collect {
                    bannerLiveData.value = it
                }
        }
    }
    //热门文章
    fun getHotBlog(isRefresh: Boolean) {
        if (isRefresh) hotBlogPage = 0
        lifecycleScope.launch {
            repos.getHotBlog(hotBlogPage)
                .collect {
                    if (it.pageCount != hotBlogPage) {
                        hotBlogPage++
                    }
                    hotBlogLiveData.value = it
                }
        }
    }
    //热门项目
    fun getHotProject() {
        lifecycleScope.launch {
            repos.getProject()
                .collect {
                    hotProjectLiveData.value = it
                }
        }
    }
    //每日问答
    fun getDailyQA(isRefresh: Boolean){
        if (isRefresh) dailyQAPage = 0
        lifecycleScope.launch {
            repos.getDailyQA(dailyQAPage)
                .collect {
                    if (it.pageCount!=dailyQAPage){
                        dailyQAPage++
                    }
                    dailyDataLiveData.value=it
                }
        }
    }
}