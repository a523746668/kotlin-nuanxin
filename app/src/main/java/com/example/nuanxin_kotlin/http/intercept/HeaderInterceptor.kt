package com.example.nuanxin_kotlin.http.intercept


import com.example.nuanxin_kotlin.util.SPUtils.getString
import com.example.nuanxin_kotlin.config.Constants.TOKEN_KEY

import com.example.nuanxin_kotlin.http.UrlConstant.BASE_URL

import okhttp3.Interceptor
import kotlin.Throws

import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val token = getString(TOKEN_KEY)
        val request = original.newBuilder()
            .header("token", token!!)
            .addHeader("Referer", BASE_URL + "/")
            .method(original.method, original.body)
            .build()
        return chain.proceed(request)
    }
}