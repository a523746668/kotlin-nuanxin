package com.example.nuanxin_kotlin.bean.home

import com.example.nuanxin_kotlin.bean.home.HeartInfo
import com.example.nuanxin_kotlin.bean.home.BloodInfo
import com.example.nuanxin_kotlin.bean.home.SleepInfo
import com.example.nuanxin_kotlin.bean.home.StepsInfo
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.HeartRateVOBean
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.DeviceMsgStepBean
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.BloodPressureBean
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.DeviceMsgStepBean.StepRes
import java.io.Serializable

/*
 * @author : created by RX
 * Date : 2021/10/27
 * PackageName: com.unicom.warmfamily.app.model.home
 */
class StepsInfo : Serializable {
    var stepCount = 0
    var reportTime: String? = null
}