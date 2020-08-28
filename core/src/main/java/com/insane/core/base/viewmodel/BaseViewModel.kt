package com.insane.core.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

/**
 *Created by Insane
 */
open class BaseViewModel : ViewModel() {
    var lifecycleScope = viewModelScope
}