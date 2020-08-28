package com.insane.jetpackproject.bean.home

/**
 * Created by Insane
 */
data class HotBlogData(
    /**
     * apkLink :
     * audit : 1
     * author :
     * canEdit : false
     * chapterId : 169
     * chapterName : gradle
     * collect : false
     * courseId : 13
     * desc :
     * descMd :
     * envelopePic :
     * fresh : false
     * id : 14939
     * link : https://juejin.im/post/6862992866131017735
     * niceDate : 2020-08-23 23:45
     * niceShareDate : 2020-08-23 23:44
     * origin :
     * prefix :
     * projectLink :
     * publishTime : 1598197505000
     * realSuperChapterId : 150
     * selfVisible : 0
     * shareDate : 1598197464000
     * shareUser : 鸿洋
     * superChapterId : 60
     * superChapterName : 开发环境
     * tags : []
     * title : Gradle 构建学习（一）---------详解 Project
     * type : 0
     * userId : 2
     * visible : 1
     * zan : 0
     */
    var apkLink: String? = null,
    var audit: Int = 0,
    var author: String? = null,
    var isCanEdit: Boolean = false,
    var chapterId: Int = 0,
    var chapterName: String? = null,
    var isCollect: Boolean = false,
    var courseId: Int = 0,
    var desc: String? = null,
    var descMd: String? = null,
    var envelopePic: String? = null,
    var isFresh: Boolean = false,
    var id: Int = 0,
    var link: String? = null,
    var niceDate: String? = null,
    var niceShareDate: String? = null,
    var origin: String? = null,
    var prefix: String? = null,
    var projectLink: String? = null,
    var publishTime: Long = 0,
    var realSuperChapterId: Int = 0,
    var selfVisible: Int = 0,
    var shareDate: Long = 0,
    var shareUser: String? = null,
    var superChapterId: Int = 0,
    var superChapterName: String? = null,
    var title: String? = null,
    var type: Int = 0,
    var userId: Int = 0,
    var visible: Int = 0,
    var zan: Int = 0,
    var tags: List<*>
)