package com.insane.jetpackproject.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
import com.insane.core.network.BaseException
import com.insane.core.network.RequestCallback
import com.insane.jetpackproject.bean.login.Login
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class LoginViewModel(private var mRepos: LoginReposition) : BaseViewModel() {
    val userInfoLiveData = MutableLiveData<Login>()
    fun login(userName: String, passWord: String) {
        lifecycleScope.launch {
            mRepos.execute(object : RequestCallback<Login> {
                override fun onSuccess(data: Login) {
                    userInfoLiveData.value = data
                }
            }) {
                mRepos.login(userName, passWord)
            }
        }
    }

    override fun onCleared() {
        lifecycleScope.cancel()
    }

}