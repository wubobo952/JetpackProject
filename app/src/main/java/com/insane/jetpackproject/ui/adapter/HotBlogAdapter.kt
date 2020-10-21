package com.insane.jetpackproject.ui.adapter

import android.text.TextUtils
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.insane.jetpackproject.R
import com.insane.jetpackproject.bean.home.HotBlogData

/**
 *Created by Insane
 */
class HotBlogAdapter : BaseQuickAdapter<HotBlogData, BaseViewHolder>(R.layout.item_hot_blog_layout),
    LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: HotBlogData) {
        val authorTv = holder.getView<TextView>(R.id.vHotBlogAuthorTv)
        val author = holder.getView<TextView>(R.id.vHotBlogAuthor)
        when (TextUtils.isEmpty(item.author)) {
            true -> {
                author.text = context.resources.getText(R.string.share)
                authorTv.text = item.shareUser
            }
            else -> {
                author.text=context.resources.getText(R.string.author)
                authorTv.text = item.author
            }
        }
        holder.setText(R.id.vHotBlogTitle, item.title)
        holder.setText(R.id.vHotBlogTagTv, item.superChapterName)
        holder.setText(R.id.vHotBlogTimeTv, item.niceShareDate)
    }

}