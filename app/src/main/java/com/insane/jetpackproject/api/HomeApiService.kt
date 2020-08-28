package com.insane.jetpackproject.api

import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.HotBlog
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *Created by Insane
 */
interface HomeApiService {

    @GET("banner/json")
    suspend fun getHomeBanner(): BaseResponse<List<Banner>>

    @GET("article/list/{path}/json")
    suspend fun getHotBlog(@Path("path") page: Int): BaseResponse<HotBlog>
}