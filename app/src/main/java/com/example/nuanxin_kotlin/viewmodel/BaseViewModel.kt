package com.example.nuanxin_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuanxin_kotlin.bean.BaseResultModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @author: zhanghaifeng
 * @date: 2022/9/7
 * Description
 */
abstract class BaseViewModel : ViewModel() {
    val loadIngLiveData = MutableLiveData<Boolean>()
    val checkResultLiveData=MutableLiveData<BaseResultModel>()
    /*
        异步操作，显示loadding
     */
    fun <T:BaseResultModel> launchForLoad(block: suspend CoroutineScope.() -> T) {
        loadIngLiveData.value = true
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.i("tmd", throwable.message!!)
            loadIngLiveData.value = false
        }
        viewModelScope.launch(exception) {
            var result=block()
            checkResultLiveData.value=result
            loadIngLiveData.value = false
        }

    }



    /*
       异步操作
     */
    fun launchForEach(block: () -> Unit){
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.i("tmd", throwable.message!!)
        }
        viewModelScope.launch(exception) {
            block()
            loadIngLiveData.value = false
        }
    }
}