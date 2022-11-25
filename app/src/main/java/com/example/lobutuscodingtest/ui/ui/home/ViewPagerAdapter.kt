package com.example.lobutuscodingtest.ui.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {

    var fragmentList: List<Fragment> = Collections.emptyList()
    var fragmentTitle: List<String> = Collections.emptyList()

    override fun getCount(): Int {
       return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment, fragmentName: String)
    {
        fragmentList.toMutableList().add(fragment)
        fragmentTitle.toMutableList().add(fragmentName)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]

    }
}