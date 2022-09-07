package com.example.nuanxin_kotlin

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract  class BaseActivity<T: ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding:T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        mBinding = DataBindingUtil.setContentView<T>(this,getLayoutId())
    }

    abstract fun getLayoutId(): Int

}