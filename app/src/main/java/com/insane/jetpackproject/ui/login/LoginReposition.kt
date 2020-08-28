package com.insane.jetpackproject.ui.login

import com.insane.core.base.repository.BaseReposition
import com.insane.core.network.BaseResponse
import com.insane.jetpackproject.api.LoginApiService
import com.insane.jetpackproject.bean.login.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *Created by Insane
 */
class LoginReposition : BaseReposition<LoginApiService>(LoginApiService::class.java) {
    suspend fun login(userName: String, passWord: String): BaseResponse<Login> {
        return withContext(Dispatchers.IO) {
            serviceApi.login(userName, passWord)
        }
    }

}