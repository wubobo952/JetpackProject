package com.insane.jetpackproject.bean.mine

import java.io.Serializable

/**
 * Created by Insane
 */
data class CollectBlogData(

    /**
     * author : 鸿洋
     * chapterId : 408
     * chapterName : 鸿洋
     * courseId : 13
     * desc :
     * envelopePic :
     * id : 136369
     * link : https://mp.weixin.qq.com/s/3QhMGVIcR1yW3xweJCa-9Q
     * niceDate : 2020-06-01 23:28
     * origin :
     * originId : 13720
     * publishTime : 1591025329000
     * title : 面试官: 说一下你做过哪些性能优化?
     * userId : 1983
     * visible : 0
     * zan : 0
     */
    var author: String? = null,
    var chapterId: Int = 0,
    var chapterName: String? = null,
    var courseId: Int = 0,
    var desc: String? = null,
    var envelopePic: String? = null,
    var id: Int = 0,
    var link: String? = null,
    var niceDate: String? = null,
    var origin: String? = null,
    var originId: Int = 0,
    var publishTime: Long = 0,
    var title: String? = null,
    var userId: Int = 0,
    var visible: Int = 0,
    var zan: Int = 0
) : Serializable {

}