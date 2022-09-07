package com.example.nuanxin_kotlin.util

import com.example.nuanxin_kotlin.util.MD5Util
import java.lang.Exception
import java.security.MessageDigest
import java.util.*
import kotlin.jvm.JvmStatic

/*
 *
 * @auth : stamSuper
 *
 * @create : 2019/1/22 20:38
 *
 * @Desc :
 */
object MD5Util {
    //公盐
    private const val PUBLIC_SALT = "smart"

    //十六进制下数字到字符的映射数组
    private val hexDigits = arrayOf(
        "0", "1", "2", "3", "4",
        "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
    )

    fun encodeByMd5Special(originString: String?): String {
        val md5 = encodeByMD5(originString)
        return getRandomString(3) + md5 + getRandomString(3)
    }

    /**
     * 用户密码加密，盐值为 ：私盐+公盐
     *
     * @param password 密码
     * @param salt     私盐
     * @return MD5加密字符串
     */
    fun encryptPassword(password: String, salt: String): String? {
        return encodeByMD5(PUBLIC_SALT + password + salt)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val str = "2020@test" //aaa|4044c6ceab7a4339a1f0b943c5806f99|1558402041000
        //        String re =  encodeByMD5(str);
        val re = getRandomString(3)
        println("======re = " + re + " length = " + re.length)
    }

    /**
     * md5加密算法
     *
     * @param originString
     * @return
     */
    fun encodeByMD5(originString: String?): String? {
        if (originString != null) {
            try {
                //创建具有指定算法名称的信息摘要
                val md = MessageDigest.getInstance("MD5")
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                val results = md.digest(originString.toByteArray())
                //将得到的字节数组变成字符串返回
                return byteArrayToHexString(results)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        return null
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @return 十六进制字符串
     */
    private fun byteArrayToHexString(b: ByteArray): String {
        val resultSb = StringBuffer()
        for (i in b.indices) {
            resultSb.append(byteToHexString(b[i]))
        }
        return resultSb.toString()
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private fun byteToHexString(b: Byte): String {
        var n = b.toInt()
        if (n < 0) n = 256 + n
        val d1 = n / 16
        val d2 = n % 16
        return hexDigits[d1] + hexDigits[d2]
    }

    //length用户要求产生字符串的长度
    fun getRandomString(length: Int): String {
        val str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = Random()
        val sb = StringBuffer()
        for (i in 0 until length) {
            val number = random.nextInt(62)
            sb.append(str[number])
        }
        return sb.toString()
    }
}