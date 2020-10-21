package com.insane.jetpackproject.ui.login

import com.insane.core.base.repository.BaseReposition
import com.insane.core.network.RetrofitEngine
import com.insane.jetpackproject.api.LoginApiService
import com.insane.jetpackproject.bean.login.Login
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 *Created by Insane
 */
class LoginReposition : BaseReposition<LoginApiService>() {
    private val api =
        RetrofitEngine.instance.getRetrofit(LoginApiService::class.java)


    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun login(userName: String, passWord: String): Flow<Login> {
        return execute {
            api.login(userName, passWord)
        }
    }
}