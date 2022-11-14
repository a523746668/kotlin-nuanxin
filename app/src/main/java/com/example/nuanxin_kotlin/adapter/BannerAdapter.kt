package com.example.nuanxin_kotlin.adapter

import android.widget.ImageView
import com.example.nuanxin_kotlin.R
import com.example.nuanxin_kotlin.bean.home.BannerInfo
import com.example.nuanxin_kotlin.http.GlideClient
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

/**
 * @author: zhanghaifeng
 * @date: 2022/9/6
 * Description
 */
class BannerAdapter :BaseBannerAdapter<BannerInfo>() {
    override fun bindData(
        holder: BaseViewHolder<BannerInfo>?,
        data: BannerInfo?,
        position: Int,
        pageSize: Int
    ) {
            var imageView =holder!!.findViewById<ImageView>(R.id.banner_iv)
             data?.path?.let { GlideClient.loadImgWithUrl(it,imageView) }
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.banner_item_layout
    }
}