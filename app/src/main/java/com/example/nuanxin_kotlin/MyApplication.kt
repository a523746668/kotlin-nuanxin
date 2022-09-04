package com.example.nuanxin_kotlin

import android.app.Application
import com.example.nuanxin_kotlin.MyApplication

/**
 * @PACKAGE_NAME： com.example.locationapp
 * @author： zhanghaifeng
 * @time： 2022/4/4
 * @description：
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        myApplication = this
    }

    companion object {
        var myApplication: MyApplication? = null
            private set
    }
}