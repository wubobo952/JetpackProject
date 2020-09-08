package com.insane.core.base.repository

import android.util.Log
import com.insane.core.network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Insane
 */
open class BaseReposition<T>(api: Class<T>) {
    //创建 retrofit
    var serviceApi = RetrofitEngine.instance.getRetrofit(api)


    suspend fun <T> execute(
        callback: RequestCallback<T>,
        block: suspend () -> BaseResponse<T>
    ) {
        val response: BaseResponse<T>
        try {
            response = block()
            if (response.errorMsg.isNotEmpty() || response.errorCode < HttpConfig.SUCCESS_CODE) throw BaseException(
                response.errorCode,
                response.errorMsg
            )
        } catch (throwable: Throwable) {
            callback.onFail(BaseException(HttpConfig.FAIL_CODE,throwable.message))
            return
        }
        withContext(Dispatchers.Main) {
            callback.onSuccess(response.data)
        }
    }
}