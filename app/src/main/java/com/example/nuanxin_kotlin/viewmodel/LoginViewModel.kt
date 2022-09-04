package com.example.nuanxin_kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuanxin_kotlin.bean.BaseResultModel
import com.example.nuanxin_kotlin.bean.LoginResultModel
import com.example.nuanxin_kotlin.http.RetrofitClient
import com.example.nuanxin_kotlin.http.ServerInterface
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

/**
 * @PACKAGE_NAME： com.example.nuanxin_kotlin.viewmodel
 * @author： zhanghaifeng
 * @time： 2022/4/23
 * @description：
 */

class LoginViewModel : ViewModel() {
    val codeResult=MutableLiveData<BaseResultModel>()
    val loginResult=MutableLiveData<LoginResultModel>()

    fun getSmsCode(phone: String) {
        viewModelScope.launch {
            var json = JsonObject()
            json.addProperty("phoneNumber", phone)
            json.addProperty("sendType", 2)
            val result = RetrofitClient.create(ServerInterface::class.java).sendSmsCode(json)
            codeResult.value = result!!
        }
    }

    fun toLogin(phone: String,code:String,password:String) {
        viewModelScope.launch {
            var json = JsonObject()
            json.addProperty("phoneNumber", phone)
            json.addProperty("password", password)
            json.addProperty("smsCode", password)
            val result = RetrofitClient.create(ServerInterface::class.java).login(json)
            loginResult.value = result!!
        }
    }
}