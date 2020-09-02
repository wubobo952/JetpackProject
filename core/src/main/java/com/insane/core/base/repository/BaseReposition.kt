package com.insane.core.base.repository

import com.insane.core.network.RetrofitEngine

/**
 * Created by Insane
 */
open class BaseReposition<T>(api: Class<T>) {
    //创建 retrofit
    var serviceApi = RetrofitEngine.instance.getRetrofit(api)

    protected fun <T> execute(){

    }
}