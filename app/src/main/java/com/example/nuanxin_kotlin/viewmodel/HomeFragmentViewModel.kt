package com.example.nuanxin_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuanxin_kotlin.bean.BaseResultModel
import com.example.nuanxin_kotlin.bean.home.BannerResultModel
import com.example.nuanxin_kotlin.bean.home.HomeHealthModel
import com.example.nuanxin_kotlin.bean.home.HomeWarnModel
import com.example.nuanxin_kotlin.http.RetrofitClient
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

/**
 * @author: zhanghaifeng
 * @date: 2022/9/6
 * Description
 */
class HomeFragmentViewModel : BaseViewModel() {
    val bannerResult = MutableLiveData<BannerResultModel?>()
    val healthResult = MutableLiveData<HomeHealthModel>()
    val remindResult = MutableLiveData<HomeWarnModel>()

    fun getBanner() {
        launchForEach {
            val result = RetrofitClient.defaultService.getBannerList(0)
            bannerResult.value = result
            result!!
        }
    }


    fun getHealthData() {

    }


    fun getRemindData() {
        launchForEach {
            val result = RetrofitClient.defaultService.getHomeWarnList()
            remindResult.value = result
            result!!
        }
    }

}