package com.insane.jetpackproject.ui.login

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.view.BaseActivity
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.jetpackproject.R
import com.insane.jetpackproject.ui.mine.MineActivity

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
        mViewModel.userInfoLiveData.observe(this, Observer {
            startActivity(Intent(this,MineActivity::class.java))
        })
    }
}