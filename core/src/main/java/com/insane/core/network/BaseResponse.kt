package com.insane.core.network

import java.io.Serializable

/**
 *Created by Insane
 */
data class BaseResponse<T>(var data: T, var errorCode: Int, var errorMsg: String) : Serializable {
}