package com.example.bookon.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bookon.fragment.HistoryFragment
import com.example.bookon.fragment.HomeFragment
import com.example.bookon.fragment.ProfileFragment


internal class PagerViewAdapter (fm: FragmentManager?):
    FragmentPagerAdapter(fm!!){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                HomeFragment()
            }
            1 -> {
                HistoryFragment()
            }
            2 -> {
                ProfileFragment()
            }
            else -> HomeFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}