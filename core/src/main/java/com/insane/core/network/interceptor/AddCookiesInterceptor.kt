package com.insane.core.network.interceptor

import android.content.Context
import android.text.TextUtils
import com.insane.core.base.utils.SpUtil
import com.insane.core.network.HttpConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


/**
 *Created by Insane
 */

class AddCookiesInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val request: Request = chain.request()
        val builder: Request.Builder = request.newBuilder()
        val cookie = getCookie(request.url().toString(), request.url().host())
        cookie?.apply {
            // 将 Cookie 添加到请求头
            builder.addHeader(HttpConfig.COOKIE, this)
        }
        return chain.proceed(builder.build())
    }

    private fun getCookie(url: String, domain: String): String? {
        return if (!TextUtils.isEmpty(domain)) {
            SpUtil.getString(domain, "")
        } else ""
    }
}