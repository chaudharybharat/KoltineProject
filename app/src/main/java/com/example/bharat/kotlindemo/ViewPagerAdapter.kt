package mchehab.com.gridviewviewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by muhammadchehab on 12/8/17.
 */
class ViewPagerAdapter(val fragmentManager: FragmentManager, val listFragment: List<Fragment>):
        FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment.size
    }
}