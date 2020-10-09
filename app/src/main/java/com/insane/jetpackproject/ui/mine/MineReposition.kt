package com.insane.jetpackproject.ui.mine

import com.insane.core.base.repository.BaseReposition
import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.api.MineApiService
import com.insane.jetpackproject.bean.login.Login
import com.insane.jetpackproject.bean.mine.CollectBlog
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 *Created by Insane
 */
class MineReposition : BaseReposition<MineApiService>(MineApiService::class.java) {
    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getCollectBlog(page:Int): Flow<CollectBlog> {
        return execute {
            serviceApi.getCollect(page)
        }
    }
}