package com.example.nuanxin_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract  class BaseActivity<T: ViewDataBinding> : AppCompatActivity() {
    protected  var  mDataBind :T?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBind=DataBindingUtil.setContentView(this,getLayout())
        mDataBind?.lifecycleOwner=this
        setContentView(mDataBind?.root)
    }



    abstract fun getLayout(): Int

}