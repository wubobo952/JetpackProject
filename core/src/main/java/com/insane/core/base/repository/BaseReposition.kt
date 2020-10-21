package com.insane.core.base.repository

import android.util.Log
import com.insane.core.base.utils.ToastUtil
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
open class BaseReposition<T> {
    private val TAG = javaClass.simpleName

    @ExperimentalCoroutinesApi
    suspend fun <T> execute(block: suspend () -> BaseResponse<T>) = flow<T> {
        block.invoke().data?.let {
            emit(it)
        }
    }.catch {

    }.flowOn(Dispatchers.IO)
        .onCompletion {
            if (block.invoke().errorMsg.isNotEmpty()) {
                ToastUtil.showToast(block.invoke().errorMsg)
            }
        }


}