package com.insane.jetpackproject.ui.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.core.base.view.BaseActivity
import com.insane.jetpackproject.R
import com.insane.jetpackproject.ui.login.LoginReposition
import com.insane.jetpackproject.ui.login.LoginViewModel

class MineActivity : BaseActivity() {


    private val mViewModel by lazy {
        ViewModelProvider(
            this,
            BaseViewModelFactory(MineReposition())
        ).get(MineViewModel::class.java)
    }

    override fun getLayout() = R.layout.activity_mine

    override fun initView() {
    }

    override fun initData() {
        mViewModel.getCollectBlog(0)
    }
}