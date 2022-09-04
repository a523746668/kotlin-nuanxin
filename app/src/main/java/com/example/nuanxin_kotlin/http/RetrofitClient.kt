package com.example.nuanxin_kotlin.http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * @PACKAGE_NAME： com.example.nuanxin_kotlin.http
 * @author： zhanghaifeng
 * @time： 2022/4/23
 * @description：
 */
private const val TIME_OUT_LENGTH = 8L
private  val BASE_URL = "http://10.9.102.68:32647"
object RetrofitClient {


    private  val  okHttpClient:OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
            .callTimeout(TIME_OUT_LENGTH, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT_LENGTH, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_LENGTH, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT_LENGTH, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor {
                it.proceed(it.request()).apply {
                    Log.d("tmd", "request $code")
                }
            }
//        initLoggingInterceptor()?.also {
//            builder.addInterceptor(it)
//        }
//        handleOkHttpClientBuilder(builder)
        builder.build()
    }

    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)

    fun handleOkHttpClientBuilder(builder: OkHttpClient.Builder) {}


}