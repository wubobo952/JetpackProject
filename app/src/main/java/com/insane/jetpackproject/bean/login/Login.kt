package com.insane.jetpackproject.bean.login

/**
 *Created by Insane
 */
data class Login(
    var isAdmin: Boolean = false,
    var coinCount: Int = 0,
    var email: String? = null,
    var icon: String? = null,
    var id: Int = 0,
    var nickname: String? = null,
    var password: String? = null,
    var publicName: String? = null,
    var token: String? = null,
    var type: Int = 0,
    var username: String? = null,
    var chapterTops: List<*>? = null,
    var collectIds: List<Int>? = null
)