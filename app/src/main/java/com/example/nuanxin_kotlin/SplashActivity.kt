package com.example.nuanxin_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import androidx.databinding.ViewDataBinding
import com.example.nuanxin_kotlin.config.Constants
import com.example.nuanxin_kotlin.databinding.ActivitySplashBinding
import com.example.nuanxin_kotlin.util.SPUtils

class SplashActivity() :BaseActivity<ActivitySplashBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         Handler().postDelayed({
            var token=SPUtils.getString(Constants.TOKEN_KEY)
            if(TextUtils.isEmpty(token)){
                startActivity(Intent(this,LoginActivity::class.java))
            }else {
                startActivity(Intent(this,MainActivity::class.java))
            }
              finish()
         },500)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }
}