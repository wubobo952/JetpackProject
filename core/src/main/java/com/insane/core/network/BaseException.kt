package com.insane.core.network

import java.lang.Exception

/**
 *Created by Insane
 */
open class BaseException(val errorCode: Int, var errorMsg: String?) : Exception(errorMsg) {

}