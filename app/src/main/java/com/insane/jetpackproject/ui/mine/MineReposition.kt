package com.insane.jetpackproject.ui.mine

import com.insane.core.base.repository.BaseReposition
import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.api.MineApiService
import com.insane.jetpackproject.bean.login.Login
import com.insane.jetpackproject.bean.mine.CollectBlog

/**
 *Created by Insane
 */
class MineReposition : BaseReposition<MineApiService>(MineApiService::class.java) {
    suspend fun getCollectBlog(page:Int): BaseResponse<CollectBlog> {
        return serviceApi.getCollect(page)
    }
}