package com.example.nuanxin_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nuanxin_kotlin.bean.UserInfo
import com.example.nuanxin_kotlin.config.Constants
import com.example.nuanxin_kotlin.databinding.ActivityLoginBinding
import com.example.nuanxin_kotlin.util.GsonUtils
import com.example.nuanxin_kotlin.util.MD5Util
import com.example.nuanxin_kotlin.util.SPUtils
import com.example.nuanxin_kotlin.viewmodel.LoginViewModel
import java.util.*

class LoginActivity() : BaseActivity<ActivityLoginBinding>() {
    private var loginModel: LoginViewModel? = null
    private var mUserAcount: String? = null;
    private var mCode: String? = null
    private var mPassWord: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginModel = ViewModelProvider(this)[LoginViewModel::class.java]
        initObserver()

    }

    private fun initObserver() {
        loginModel!!.codeResult.observe(this, Observer {
            if (it.code == 0) {
                Toast.makeText(this, "短信发送成功", Toast.LENGTH_SHORT).show()
                object :CountDownTimer(1000*60,1000) {
                    override fun onTick(p0: Long) {
                        mBinding!!.getVerificationCode.text= (p0/1000).toString()+"秒"
                        mBinding!!.getVerificationCode.isEnabled=false
                    }
                    override fun onFinish() {
                        mBinding!!.getVerificationCode.isEnabled=true
                        mBinding!!.getVerificationCode.setText("获取验证码")
                    }
                }.start()
            } else {
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
            }
        })

       loginModel!!.loginResult.observe(this, Observer {
             if(it.code==0){
                SPUtils.putString(Constants.TOKEN_KEY,it.data?.token)
                var userStr=GsonUtils.beanToGson(it.data)
                SPUtils.putString(Constants.USER_NAME,userStr)
                startActivity(Intent(this,MainActivity::class.java))
             }else {
                Toast.makeText(this,it.msg,Toast.LENGTH_SHORT).show()
             }
       })
    }


    fun onclick(view: View) {

        var id = view.id
        when (id) {
            R.id.btn_login -> toLogin();
            R.id.getVerificationCode -> toSmsCode()
        }

    }

    private fun toSmsCode() {
         if(TextUtils.isEmpty(mBinding!!.edUser.text.toString())) {
             Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show()
             return
         }
        loginModel!!.getSmsCode(mBinding!!.edUser.text.toString())
    }

    private fun toLogin() {
        if(TextUtils.isEmpty(mBinding!!.edUser.text.toString())) {
            Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show()
            return
        }
        loginModel!!.toLogin(mBinding!!.edUser.text.toString().trim(), mBinding!!.edVerCode.text.toString().trim(), MD5Util.encodeByMd5Special(mBinding!!.editPwd.text.toString().trim()) )
    }

    override fun getLayoutId(): Int {
        return   R.layout.activity_login
    }


}






