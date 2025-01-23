package com.example.hw5_m5

import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardAdapter(fragment: OnBoardFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): OnBoardViewPagerFragment {
        val fragment = OnBoardViewPagerFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
        return fragment
    }
}