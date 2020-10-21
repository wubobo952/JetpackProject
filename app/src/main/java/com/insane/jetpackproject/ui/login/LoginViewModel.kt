package com.insane.jetpackproject.ui.login

import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
import com.insane.jetpackproject.bean.login.Login
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class LoginViewModel(private var mRepos: LoginReposition) : BaseViewModel() {
    var userInfoLiveData = MutableLiveData<Login>()
    fun login(userName: String, passWord: String) {
        lifecycleScope.launch {
            mRepos.login(userName, passWord)
                .collect {
                    userInfoLiveData.value = it
                }

        }
    }

    override fun onCleared() {
        lifecycleScope.cancel()
    }

}