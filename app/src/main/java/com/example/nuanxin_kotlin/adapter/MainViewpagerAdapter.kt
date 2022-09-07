package com.example.nuanxin_kotlin.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nuanxin_kotlin.BaseActivity
import com.example.nuanxin_kotlin.fragment.BaseFragment

/**
 * @author: zhanghaifeng
 * @date: 2022/9/6
 * Description
 */
class MainViewpagerAdapter(activity: AppCompatActivity, val listFragment: List<Fragment>) :
    FragmentStateAdapter(activity) {


    override fun getItemCount(): Int {

        return listFragment.count()
    }

    override fun createFragment(position: Int): Fragment {

        return listFragment.get(position)
    }
}