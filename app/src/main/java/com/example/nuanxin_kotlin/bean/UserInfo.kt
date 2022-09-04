package com.example.nuanxin_kotlin.bean

/**
 * @PACKAGE_NAME： com.example.nuanxin_kotlin.bean
 * @author： zhanghaifeng
 * @time： 2022/4/19
 * @description：
 */
class UserInfo constructor(i: Int, s: String) {
    var token: String?=null
    var phoneNumber: String? = null
    var customerId: String? = null
    var nickName: String? = null
    var headImg: String? = null
    var sex =0
    var custType // 0-监护人(子女) 1-老人  2-其它
            = 0
    var familyGroupId: String? = null
    var familyName: String? = null

    init {
        token = s
        sex = i
    }
}