package com.insane.jetpackproject.ui.mine

import androidx.lifecycle.MutableLiveData
import com.insane.core.base.viewmodel.BaseViewModel
import com.insane.jetpackproject.bean.mine.CollectBlog
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by Insane
 */
class MineViewModel(private val mRepos: MineReposition) : BaseViewModel() {
    var mCollectBlogData = MutableLiveData<CollectBlog>()
    fun getCollectBlog(page: Int) {
        lifecycleScope.launch {
            mRepos.getCollectBlog(page).collect {
                mCollectBlogData.value = it

            }
        }
    }
}