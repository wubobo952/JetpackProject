package com.insane.jetpackproject.api

import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.bean.home.Banner
import com.insane.jetpackproject.bean.home.DailyQA
import com.insane.jetpackproject.bean.home.HotBlog
import com.insane.jetpackproject.bean.home.HotProjectTree
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *Created by Insane
 */
interface HomeApiService {
    //banner
    @GET("banner/json")
    suspend fun getHomeBanner(): BaseResponse<List<Banner>>

    //热门文章
    @GET("article/list/{path}/json")
    suspend fun getHotBlog(@Path("path") page: Int): BaseResponse<HotBlog>

    //热门项目
    @GET("project/tree/json")
    suspend fun getHotProject(): BaseResponse<MutableList<HotProjectTree>>

    //每日问答
    @GET("wenda/list/{path}/json ")
    suspend fun getDailyQA(@Path("path") page: Int): BaseResponse<DailyQA>
}