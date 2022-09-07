package com.example.nuanxin_kotlin.http

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.nuanxin_kotlin.MyApplication
import com.example.nuanxin_kotlin.config.Constants
import com.example.nuanxin_kotlin.util.SPUtils

/**
 * @author: zhanghaifeng
 * @date: 2022/9/6
 * Description
 */
object GlideClient  {

        fun  loadImgWithUrl(url:String,view :ImageView){
            var context=view.context
            if(context==null){
                context=MyApplication.myApplication?.applicationContext
            }

           Glide.with(context)
               .load(getGlideUrl(url))
               .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
               .into(view)
        }


    private fun getGlideUrl(url: String): GlideUrl? {
        var token= SPUtils.getString(Constants.TOKEN_KEY)
        var realUrl=UrlConstant.IMAGE_BASE_URL+url
        return GlideUrl(
            realUrl, LazyHeaders.Builder()
                .addHeader("token", token!!)
                .addHeader("Referer", UrlConstant.BASE_URL+ "/")
                .build()
        )
    }

}