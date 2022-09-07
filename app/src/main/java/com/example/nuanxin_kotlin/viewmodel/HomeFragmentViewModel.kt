package com.example.nuanxin_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuanxin_kotlin.bean.BaseResultModel
import com.example.nuanxin_kotlin.bean.home.BannerResultModel
import com.example.nuanxin_kotlin.http.RetrofitClient
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

/**
 * @author: zhanghaifeng
 * @date: 2022/9/6
 * Description
 */
class HomeFragmentViewModel :ViewModel() {
    val bannerResult= MutableLiveData<BannerResultModel?>()

    fun getBanner(){
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->

            Log.i("tmd",throwable.message!!)
        }
          viewModelScope.launch(exception){
                  val result=RetrofitClient.defaultService.getBannerList(0)
                  if(result!=null&&result.code==0){
                      bannerResult.value=result
                  }
          }
    }

}