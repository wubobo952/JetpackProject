package com.insane.core.base.repository

import android.util.Log
import com.insane.core.network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.withContext

/**
 * Created by Insane
 */
open class BaseReposition<T>(api: Class<T>) {
    //创建 retrofit
    var serviceApi = RetrofitEngine.instance.getRetrofit(api)
    private val TAG = javaClass.simpleName

    @ExperimentalCoroutinesApi
    suspend fun <T> execute(block: suspend () -> BaseResponse<T>) = flow<T> {
        emit(block.invoke().data)
    }.catch {

    }.onCompletion {
        if (block.invoke().errorMsg.isNotEmpty()) {
            Log.e(TAG, block.invoke().errorMsg)
        }
    }.flowOn(Dispatchers.IO)

}