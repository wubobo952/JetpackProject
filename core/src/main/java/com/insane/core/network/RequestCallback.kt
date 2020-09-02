package com.insane.core.network

/**
 *Created by Insane
 */
interface RequestCallback<T> {
    fun onSuccess(data:T){}

    fun onFail(exception: BaseException)
}