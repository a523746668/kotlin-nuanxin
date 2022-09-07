package com.example.nuanxin_kotlin.http

import com.example.nuanxin_kotlin.bean.BaseResultModel
import com.example.nuanxin_kotlin.bean.LoginResultModel
import com.example.nuanxin_kotlin.bean.home.BannerResultModel
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * @PACKAGE_NAME： com.example.nuanxin_kotlin.http
 * @author： zhanghaifeng
 * @time： 2022/4/23
 * @description：
 */

interface ServerInterface {
    /* 登录 */
    @POST("/member/member/customer/login2")
    suspend fun login(@Body body: JsonObject?): LoginResultModel?

    /* 注册获取验证码 */
    @POST("/member/member/customer/sendSmsCode")
    suspend fun sendSmsCode(@Body body: JsonObject?): BaseResultModel?

    /* 获取首页banner轮播图     */
    @GET("/system/system/banner/list/{position}")
    suspend fun getBannerList(@Path("position") position: Int): BannerResultModel?
}