package com.insane.jetpackproject.bean.home

import java.io.Serializable

/**
 * Created by Insane
 */
data class HotProjectTree(
    /**
     * children : []
     * courseId : 13
     * id : 294
     * name : 完整项目
     * order : 145000
     * parentChapterId : 293
     * userControlSetTop : false
     * visible : 0
     */
    var courseId: Int = 0,
    var id: Int = 0,
    var name: String? = null,
    var order: Int = 0,
    var parentChapterId: Int = 0,
    var isUserControlSetTop: Boolean = false,
    var visible: Int = 0,
    var children: MutableList<*>
) : Serializable