package com.insane.jetpackproject.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
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
            val login = mRepos.login(userName, passWord)
            userInfoLiveData.value = login.data
        }
    }

    override fun onCleared() {
        lifecycleScope.cancel()
    }

}