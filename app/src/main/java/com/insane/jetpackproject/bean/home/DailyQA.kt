package com.insane.jetpackproject.bean.home

import java.io.Serializable

/**
 * Created by Insane
 */
data class DailyQA (
    var curPage: Int? = null,
    var offset: Int? = null,
    var isOver: Boolean? = null,
    var pageCount: Int? = null,
    var size: Int? = null,
    var total: Int? = null,
    var datas: MutableList<DailyQAData>
):Serializable