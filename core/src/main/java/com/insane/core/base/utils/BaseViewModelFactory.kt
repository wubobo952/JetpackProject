package com.insane.core.base.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.insane.core.base.repository.BaseReposition

/**
 *Created by Insane
 */
class BaseViewModelFactory(private val repos: BaseReposition<*>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(repos::class.java).newInstance(repos)
    }
}