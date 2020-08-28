package com.insane.jetpackproject.api

import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.bean.login.Login
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *Created by Insane
 */
interface LoginApiService {

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") userName:String,@Field("password") password:String):BaseResponse<Login>

}