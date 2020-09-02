package com.insane.jetpackproject.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.insane.jetpackproject.R
import com.insane.jetpackproject.bean.home.HotProjectTree

/**
 *Created by Insane
 */
class HotProjectAdapter:BaseQuickAdapter<HotProjectTree,BaseViewHolder>(R.layout.item_hot_project_item_layout) {
    override fun convert(holder: BaseViewHolder, item: HotProjectTree) {
        holder.setText(R.id.vHotProjectTiter,item.name)
        holder.setText(R.id.vHotProjectAuthorTv,"${item.order}")
    }
}