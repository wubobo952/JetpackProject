package com.insane.jetpackproject.ui.home

import com.insane.core.base.repository.BaseReposition
import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.api.HomeApiService
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.HotBlog
import com.insane.jetpackproject.bean.home.HotProjectTree
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.Flow

/**
 *Created by Insane
 */
class HomeReposition : BaseReposition<HomeApiService>(HomeApiService::class.java) {
    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getBanner():Flow<List<Banner>>{
        return execute {
            serviceApi.getHomeBanner()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getHotBlog(page: Int): Flow<HotBlog> {
       return execute {
           serviceApi.getHotBlog(page)
       }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getProject():Flow<MutableList<HotProjectTree>>{
        return execute {
            serviceApi.getHotProject()
        }
    }
}