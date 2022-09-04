package com.example.nuanxin_kotlin.util

import android.content.Context
import com.example.nuanxin_kotlin.MyApplication.Companion.myApplication

import com.example.nuanxin_kotlin.config.Constants

/**
 * @author: kermit
 * @date: 2016/9/20
 * Class description:
 * ---- SharedPreferences 相关工具类
 */
object SPUtils {


        /**
         * SP中写入String类型value
         *
         * @param key   键
         * @param value 值
         */
        @JvmStatic
        fun putString(key: String?, value: String?) {
            val sp =myApplication!!.applicationContext
                .getSharedPreferences(Constants.SP_CONFIG_NAME, Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString(key, value)
            editor.commit()
        }

        /**
         * SP中读取String
         *
         * @param key 键
         * @return 存在返回对应值，不存在返回默认值`null`
         */
        @JvmStatic
        fun getString(key: String?): String? {
            val sp = myApplication!!.applicationContext
                .getSharedPreferences(
                    Constants.SP_CONFIG_NAME,
                    Context.MODE_PRIVATE
                )
            return sp.getString(key, "")
        }

        @JvmStatic
        fun clearUser() {
            val sp = myApplication!!.applicationContext
                .getSharedPreferences(Constants.SP_CONFIG_NAME, Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.clear()
            editor.commit()
        }


}