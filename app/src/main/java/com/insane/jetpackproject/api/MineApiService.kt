package com.insane.jetpackproject.api

import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.bean.mine.CollectBlog
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *Created by Insane
 */
interface MineApiService {
    @GET("lg/collect/list/{path}/json")
    suspend fun getCollect(@Path("path") page: Int): BaseResponse<CollectBlog>
}