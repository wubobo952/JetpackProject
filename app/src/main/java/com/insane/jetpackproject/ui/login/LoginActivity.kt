package com.insane.jetpackproject.ui.login

import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.view.BaseActivity
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.jetpackproject.R

class LoginActivity : BaseActivity() {

    private val mViewModel by lazy {
        ViewModelProvider(
            this,
            BaseViewModelFactory(LoginReposition())
        ).get(LoginViewModel::class.java)
    }

    override fun getLayout() = R.layout.activity_login

    override fun initView() {

    }

    override fun initData() {
        mViewModel.login("Insane", "19960519")
    }
}