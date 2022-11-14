package com.example.nuanxin_kotlin

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.nuanxin_kotlin.config.Constants
import com.example.nuanxin_kotlin.util.SPUtils
import com.example.nuanxin_kotlin.viewmodel.BaseViewModel
import com.wang.avi.AVLoadingIndicatorView

abstract  class BaseActivity<T: ViewDataBinding,VM:BaseViewModel> : AppCompatActivity() {
    private lateinit var loadingDialog: Dialog
    lateinit var mViewModel: VM
    protected  lateinit var mBinding:T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        mBinding = DataBindingUtil.setContentView<T>(this,getLayoutId())
        mBinding.lifecycleOwner=this
        initActivity();
        createLoadingDialog()

        if(isInitObserver()){
            initSomeObserver()
        }

    }

    abstract fun initActivity()
    abstract fun getLayoutId(): Int
    open fun isInitObserver():Boolean{
       return true
    }


    fun initSomeObserver() {
        mViewModel.loadIngLiveData.observe(this) {
            showLoad(it)
        }
        mViewModel.checkResultLiveData.observe(this){
            if (it.code == Constants.TOKEN_INVALID || it.code  == Constants.TOKEN_NONE) {
                SPUtils.clearUser()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
        }
    }

    fun showLoad(it: Boolean) {
        if (it) {
            loadingDialog.show()
        } else {
            if (loadingDialog.isShowing) {
                loadingDialog.dismiss()
            }
        }
    }

    fun createLoadingDialog() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.loading_dialog, null) // 得到加载view
        val lod = v.findViewById<AVLoadingIndicatorView>(R.id.loading)
        lod.show()
        loadingDialog = Dialog(this, R.style.loading_dialog) // 创建自定义样式dialog
        loadingDialog.setCancelable(true) // 不可以用“返回键”取消
        loadingDialog.setContentView(
            v,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
    }

}