package com.example.nuanxin_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * @author: zhanghaifeng
 * @date: 2022/9/5
 * Description
 */
abstract class BaseFragment<VH: ViewDataBinding> :Fragment() {
   var dataBing :VH?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(null==dataBing){
            dataBing = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
            initFragment()
        }
        return dataBing?.root
    }


    abstract fun getLayoutResId():Int
    abstract fun initFragment()
}