package com.insane.jetpackproject.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.module.UpFetchModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.insane.jetpackproject.R
import com.insane.jetpackproject.bean.home.HotBlogData

/**
 *Created by Insane
 */
class HotBlogAdapter :BaseQuickAdapter<HotBlogData,BaseViewHolder>(R.layout.item_hot_blog_layout),LoadMoreModule,UpFetchModule{
    override fun convert(holder: BaseViewHolder, item: HotBlogData) {
        holder.setText(R.id.vHotBlogTiter,item.title)
        holder.setText(R.id.vHotBlogAuthorTv,item.author)
        holder.setText(R.id.vHotBlogTagTv,item.superChapterName)
        holder.setText(R.id.vHotBlogTimeTv,item.niceShareDate)
    }

}