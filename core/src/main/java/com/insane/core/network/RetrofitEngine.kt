package com.insane.core.network

import com.insane.core.base.App
import com.insane.core.network.interceptor.AddCookiesInterceptor
import com.insane.core.network.interceptor.SaveCookiesInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *Created by Insane
 */
open class RetrofitEngine private constructor() {
    companion object {
        val instance: RetrofitEngine by lazy {
            RetrofitEngine()
        }
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(HttpConfig.READ_TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(HttpConfig.WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(HttpConfig.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(AddCookiesInterceptor())
            .addInterceptor(SaveCookiesInterceptor())
            .build()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient())
            .baseUrl(HttpConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> getRetrofit(serviceApi: Class<T>): T {
        return createRetrofit().create(serviceApi)
    }
}