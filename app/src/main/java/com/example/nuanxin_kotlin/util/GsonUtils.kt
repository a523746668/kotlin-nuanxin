package com.example.nuanxin_kotlin.util

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @PACKAGE_NAME： com.example.nuanxin_kotlin.util
 * @author： zhanghaifeng
 * @time： 2022/5/3
 * @description：
 */

object GsonUtils {


    fun<T> beanToGson(t:T):String{
             if(null==t){
                  return ""
             }
          return Gson().toJson(t)
     }


    /**
     * Json转成对象
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
    </T> */
    fun <T> gson2Bean(json: String?, cls: Class<T>?): T? {
        var res: T? = null
        if (!TextUtils.isEmpty(json)) {
            res = Gson().fromJson(json, cls)
        }
        return res
    }


    /**
     * json转成list<T>
     *
     * @param gsonString
     * @param cls
     * @return list<T>
    </T></T> */
    fun <T> gsonToList(gsonString: String?, cls: Class<T>?): List<T>? {
        var list: List<T>? = null
            list = Gson().fromJson(gsonString, object : TypeToken<List<T>?>() {}.type)
        return list
    }


}