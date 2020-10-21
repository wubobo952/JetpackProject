package com.insane.jetpackproject.ui.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.insane.jetpackproject.R
import com.insane.jetpackproject.bean.home.DailyQAData

/**
 *Created by Insane
 */
class DailyQAAdapter :BaseQuickAdapter<DailyQAData,BaseViewHolder>(R.layout.item_daily_qa_layout),
    LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: DailyQAData) {
        holder.setText(R.id.vDailyTitle, Html.fromHtml(item.desc))
    }
}