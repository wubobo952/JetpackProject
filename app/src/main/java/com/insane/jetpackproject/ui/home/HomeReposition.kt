package com.insane.jetpackproject.ui.home

import com.insane.core.base.repository.BaseReposition
import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.api.HomeApiService
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.HotBlog
import com.insane.jetpackproject.bean.home.HotProjectTree
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *Created by Insane
 */
class HomeReposition : BaseReposition<HomeApiService>(HomeApiService::class.java) {
    suspend fun getBanner(): BaseResponse<List<Banner>> {
        val block: suspend CoroutineScope.() -> BaseResponse<List<Banner>> = {
            serviceApi.getHomeBanner()
        }
        return withContext(Dispatchers.IO, block)
    }

    suspend fun getHotBlog(page: Int): BaseResponse<HotBlog> {
        val block: suspend CoroutineScope.() -> BaseResponse<HotBlog> = {
            serviceApi.getHotBlog(page)
        }
        return withContext(Dispatchers.IO, block)
    }

    suspend fun getProject(): BaseResponse<MutableList<HotProjectTree>> {
        val block: suspend CoroutineScope.() -> BaseResponse<MutableList<HotProjectTree>> = {
            serviceApi.getHotProject()
        }
        return withContext(Dispatchers.IO, block)
    }
}