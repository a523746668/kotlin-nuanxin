package com.example.nuanxin_kotlin.bean.home

import java.io.Serializable

/**
 * @PACKAGE_NAME： com.unicom.warmfamily.app.model.home
 * @author： zhanghaifeng
 * @time： 2022/4/12
 * @description：
 */
class BannerInfo : Serializable {
    var title: String? = null
    var path: String? = null
    var url: String? = null
    var id: String? = null
    var type = 0
}