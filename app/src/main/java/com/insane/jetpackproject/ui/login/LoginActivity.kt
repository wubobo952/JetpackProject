package com.insane.jetpackproject.ui.login

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.view.BaseActivity
import com.insane.core.base.utils.BaseViewModelFactory
import com.insane.jetpackproject.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private val mViewModel by lazy {
        ViewModelProvider(
            this,
            BaseViewModelFactory(LoginReposition())
        ).get(LoginViewModel::class.java)
    }

    override fun getLayout() = R.layout.activity_login

    override fun initView() {
        btLogin.setOnClickListener {
            val userName = edUserName.text.toString().trim()
            val password = edUserPassword.text.toString().trim()
            if (userName.isNotEmpty() && password.isNotEmpty()) {
                mViewModel.login(userName, password)
            } else {
                //todo
            }
        }
        edUserPassword.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable) {
                if (edUserName.text.toString().trim().isNotEmpty()){
                    if (s.isNotEmpty()){
                        btLogin.setBackgroundResource(R.drawable.shape_radius_25_app_color)
                        btLogin.setTextColor(Color.WHITE)
                    }else{
                        btLogin.setBackgroundResource(R.drawable.shape_radius_25_d8d8d8)
                        btLogin.setTextColor(resources.getColor(R.color.black_a6,null))
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun initData() {
        mViewModel.userInfoLiveData.observe(this, Observer {
            finish()
        })
    }
}