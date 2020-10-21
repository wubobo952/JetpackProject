package com.insane.jetpackproject.bean.home

import java.io.Serializable

/**
 * Created by Insane
 */
data class DailyQAData(
    var apkLink: String? = null,
    var audit: Int? = null,
    var author: String? = null,
    var isCanEdit: Boolean? = null,
    var chapterId: Int? = null,
    var chapterName: String? = null,
    var isCollect: Boolean? = null,
    var courseId: Int? = null,
    var desc: String? = null,
    var descMd: String? = null,
    var envelopePic: String? = null,
    var isFresh: Boolean? = null,
    var id: Int? = null,
    var link: String? = null,
    var niceDate: String? = null,
    var niceShareDate: String? = null,
    var origin: String? = null,
    var prefix: String? = null,
    var projectLink: String? = null,
    var publishTime: Long? = null,
    var realSuperChapterId: Int? = null,
    var selfVisible: Int? = null,
    var shareDate: Long? = null,
    var shareUser: String? = null,
    var superChapterId: Int? = null,
    var superChapterName: String? = null,
    var title: String? = null,
    var type: Int? = null,
    var userId: Int? = null,
    var visible: Int? = null,
    var zan: Int? = null,
    var tags: List<TagsBean>? = null
) : Serializable {
    class TagsBean {
        /**
         * name : 本站发布
         * url : /article/list/0?cid=440
         */
        var name: String? = null
        var url: String? = null

    }
}