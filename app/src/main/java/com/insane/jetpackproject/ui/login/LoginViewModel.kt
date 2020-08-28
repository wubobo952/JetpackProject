package com.insane.jetpackproject.ui.login

import android.util.Log
import com.insane.core.base.viewmodel.BaseViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class LoginViewModel(private var mRepos: LoginReposition) : BaseViewModel() {
    fun login(userName: String, passWord: String) {
        lifecycleScope.launch {
            val login = mRepos.login(userName, passWord)
            Log.e("TAG--", login.data.toString())
        }
    }

    override fun onCleared() {
        lifecycleScope.cancel()
    }

}