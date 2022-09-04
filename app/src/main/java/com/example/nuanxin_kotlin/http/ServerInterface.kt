package com.example.nuanxin_kotlin.http

import com.example.nuanxin_kotlin.bean.BaseResultModel
import com.example.nuanxin_kotlin.bean.LoginResultModel
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @PACKAGE_NAME： com.example.nuanxin_kotlin.http
 * @author： zhanghaifeng
 * @time： 2022/4/23
 * @description：
 */

interface ServerInterface {
    /* 登录 */
    @POST("/member/member/customer/login")
    suspend fun login(@Body body: JsonObject?): LoginResultModel?

    /* 注册获取验证码 */
    @POST("/member/member/customer/sendSmsCode")
    suspend fun sendSmsCode(@Body body: JsonObject?): BaseResultModel?

}