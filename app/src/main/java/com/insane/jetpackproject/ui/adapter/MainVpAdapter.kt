package com.insane.jetpackproject.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *Created by Insane
 */
class MainVpAdapter(
    private var fragments: MutableList<Fragment>,
    private var titles: Array<String>,
    fm: FragmentManager,
    behavior: Int
) :
    FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}