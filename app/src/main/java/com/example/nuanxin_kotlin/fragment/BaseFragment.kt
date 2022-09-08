package com.example.nuanxin_kotlin.fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.nuanxin_kotlin.LoginActivity
import com.example.nuanxin_kotlin.R
import com.example.nuanxin_kotlin.config.Constants
import com.example.nuanxin_kotlin.util.SPUtils
import com.example.nuanxin_kotlin.viewmodel.BaseViewModel
import com.wang.avi.AVLoadingIndicatorView

/**
 * @author: zhanghaifeng
 * @date: 2022/9/5
 * Description
 */
abstract class BaseFragment<VH : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    private lateinit var loadingDialog: Dialog
    lateinit var dataBing: VH
    lateinit var mViewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBing = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        createLoadingDialog()
        initFragment()
        initSomeObserver()

        return dataBing?.root
    }


    abstract fun getLayoutResId(): Int
    abstract fun initFragment()

    fun initSomeObserver() {
        mViewModel.loadIngLiveData.observe(viewLifecycleOwner,{
            showLoad(it)
        })
        mViewModel.checkResultLiveData.observe(viewLifecycleOwner,{
            if (it.code == Constants.TOKEN_INVALID || it.code  == Constants.TOKEN_NONE) {
                SPUtils.clearUser()
                 startActivity(Intent(context,LoginActivity::class.java))
                 activity?.finish()
            }
        })
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
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.loading_dialog, null) // 得到加载view
        val lod = v.findViewById<AVLoadingIndicatorView>(R.id.loading)
        lod.show()
        loadingDialog = Dialog(requireContext(), R.style.loading_dialog) // 创建自定义样式dialog
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