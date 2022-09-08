package com.example.nuanxin_kotlin.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nuanxin_kotlin.R
import com.example.nuanxin_kotlin.adapter.BannerAdapter
import com.example.nuanxin_kotlin.bean.home.BannerInfo
import com.example.nuanxin_kotlin.databinding.FragmentHomeBinding
import com.example.nuanxin_kotlin.viewmodel.HomeFragmentViewModel
import com.example.nuanxin_kotlin.viewmodel.LoginViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeFragmentViewModel>() {


    private var bannerAdapter: BannerAdapter? = null
    private val mBanners = mutableListOf<BannerInfo>()
    fun onClick(view: View) {

    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initFragment() {
        mViewModel= ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        initBanner();
        initObserver();
        mViewModel.getBanner()
    }

    private fun initBanner() {
        bannerAdapter = BannerAdapter()
        dataBing.viewpager.setLifecycleRegistry(lifecycle)
            .setAdapter(bannerAdapter)
            .setScrollDuration(500)
            .setRoundCorner(45)
            .setIndicatorSliderColor(
                resources.getColor(R.color.color_666666),
                resources.getColor(R.color.white)
            )
            .setIndicatorSliderWidth(15, 25)
            .create()
    }

    private fun initObserver() {
        mViewModel.bannerResult.observe(this, Observer {
            if (it != null && it.code == 0 && it.data != null) {
                mBanners.clear()
                mBanners.addAll(it.data!!)
                dataBing!!.viewpager.refreshData(mBanners)
            }else {
               // Toast.makeText(context,it?.msg,0).show()
            }
        })
    }
}