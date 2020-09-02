package com.insane.core.network.interceptor
import com.insane.core.base.utils.SpUtil
import com.insane.core.network.HttpConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*


/**
 *Created by Insane
 */
class SaveCookiesInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        //set-cookie可能为多个
        if (response.headers(HttpConfig.SET_COOKIES).isNotEmpty()) {
            val cookies =
                response.headers(HttpConfig.SET_COOKIES)
            val cookie = encodeCookie(cookies)
            saveCookie(request.url().toString(), request.url().host(), cookie)
        }
        return response
    }

    //整合cookie为唯一字符串
    private fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set: MutableSet<String> = HashSet()
        for (cookie in cookies) {
            val arr = cookie.split(";".toRegex()).toTypedArray()
            for (s in arr) {
                if (set.contains(s)) {
                    continue
                }
                set.add(s)
            }
        }
        for (cookie in set) {
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }


    private fun saveCookie(
        url: String,
        domain: String,
        cookies: String
    ) {
        // 如果 response 的header 中包含 cookie 信息。并且此次请求是登录或者注册才保存cookie
        if (url.isNotEmpty() && (url.contains("user/login"))) {
            SpUtil.put(url, cookies)
            SpUtil.put(domain, cookies)
        }
    }
}