package com.example.nuanxin_kotlin

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.nuanxin_kotlin.databinding.ActivityMainBinding
import com.example.nuanxin_kotlin.fragment.HomeFragment
import com.example.nuanxin_kotlin.fragment.MyFragment
import com.example.nuanxin_kotlin.fragment.ServiceFragment

class MainActivity : AppCompatActivity() {
    private var fragments: MutableList<Fragment>? = null


    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.activity = this
        mBinding.viewPage.setCurrentItem(0, false)
        initView();
        initEvent()
    }

    private fun initEvent() {
       mBinding.bottom.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener {
           override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
               when (p1) {
                   R.id.homeView ->
                       mBinding.viewPage.setCurrentItem(0, false)
                   R.id.familyView -> mBinding.viewPage.setCurrentItem(1, false)
                   R.id.myView -> mBinding.viewPage.setCurrentItem(2, false)
               }
           }
       })
    }

    private fun initView() {
        fragments = mutableListOf()
        fragments!!.add(HomeFragment())
        fragments!!.add(ServiceFragment())
        fragments!!.add(MyFragment())
    }


}