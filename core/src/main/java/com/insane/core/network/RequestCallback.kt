package com.insane.core.network

/**
 *Created by Insane
 */
interface RequestCallback<T>:BaseRequestCallback {
    fun onSuccess(data: T)
}