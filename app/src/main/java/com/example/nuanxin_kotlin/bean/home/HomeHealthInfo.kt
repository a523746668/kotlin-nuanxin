package com.example.nuanxin_kotlin.bean.home

import com.example.nuanxin_kotlin.bean.home.HeartInfo
import com.example.nuanxin_kotlin.bean.home.BloodInfo
import com.example.nuanxin_kotlin.bean.home.SleepInfo
import com.example.nuanxin_kotlin.bean.home.StepsInfo
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.HeartRateVOBean
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.DeviceMsgStepBean
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.BloodPressureBean
import com.example.nuanxin_kotlin.bean.home.HomeHealthInfo.DeviceMsgStepBean.StepRes

/*
 * @author : created by RX
 * Date : 2022/3/30
 * PackageName: com.unicom.warmfamily.app.model.home
 */
class HomeHealthInfo {
    var heartRateVO: HeartInfo? = null
    var bloodPressureVO: BloodInfo? = null
    var sleepVO: SleepInfo? = null
    var stepVO: StepsInfo? = null
    var heartRateVOList: List<HeartRateVOBean>? = null
    var deviceMsgStepVO: DeviceMsgStepBean? = null
    var bloodPressureVOList: List<BloodPressureBean>? = null

    inner class HeartRateVOBean {
        var heartRate = 0
        var reportTime: String? = null
        var msgType = 0
        var msgResult: String? = null
    }

    inner class BloodPressureBean {
        var diastolicBloodPressure = 0
        var systolicBloodPressure = 0
        var reportTime: String? = null
    }

    inner class DeviceMsgStepBean {
        var stepRes: List<StepRes>? = null
        var stepSum = 0
        var targetStep = 0
        var calorie = 0.0
        var lengths = 0.0
        var sportsTime = 0

        inner class StepRes {
            var stepCount = 0
            var reportTime: String? = null
        }
    }
}