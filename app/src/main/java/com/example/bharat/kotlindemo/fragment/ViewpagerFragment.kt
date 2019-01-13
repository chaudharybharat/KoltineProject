package com.example.bharat.kotlindemo.fragment


import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.example.bharat.kotlindemo.R
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import mchehab.com.gridviewviewpager.ImageFragment
import mchehab.com.gridviewviewpager.ViewPagerAdapter
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewpagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponet();

    }

    private fun initComponet() {
        val alphabets = listOf(
                "a","b","c","d","e","f","g","h","i",
                "j","k","l","m","n","o","p","q","r",
                "s","t","u","v","w","x","y","z"
        )

        // Initialize a new pager adapter instance with list
        val adapter = AlphabetPagerAdapter(alphabets)

        // Finally, data bind the view pager widget with pager adapter
        view_pager.adapter = adapter

        // Set up tab layout with view pager widget
        tab_layout.setupWithViewPager(view_pager)

        // Make the tab layout scrollable
        tab_layout.tabMode = TabLayout.MODE_SCROLLABLE
    }

    /*private fun getArguments(){
        val bundle = intent.extras
        position = bundle.getInt("position")
        listImageURLs = bundle.getStringArrayList("imageURLs")
    }*/

    class AlphabetPagerAdapter(private val list: List<String>) : PagerAdapter() {

        override fun isViewFromObject(v: View, `object`: Any): Boolean {
            // Return the current view
            return v === `object` as View
        }


        override fun getCount(): Int {
            // Count the items and return it
            return list.size
        }


        override fun instantiateItem(parent: ViewGroup?, position: Int): Any {
            // Get the view from pager page layout
            val view = LayoutInflater.from(parent?.context)
                    .inflate(R.layout.row_viewpager,parent,false)

            // Get the widgets reference from layout
            val linearLayout: LinearLayout = view.findViewById(R.id.linear_layout)
            val textView: TextView = view.findViewById(R.id.text_view)
            val tvFooter: TextView = view.findViewById(R.id.tv_footer)

            // Set the text views text
            textView.text = "${list.get(position)} \n ${list.get(position).toUpperCase()}"
            tvFooter.text = "Page ${position+1} of ${list.size}"

            // Set the text views text color
            textView.setTextColor(randomLightColor(70,80))
            tvFooter.setTextColor(randomLightColor(100,25))

            // Set the layout background color
            linearLayout.setBackgroundColor(randomLightColor(25))

            // Add the view to the parent
            parent?.addView(view)

            // Return the view
            return view
        }


        override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
            // Remove the view from view group specified position
            parent.removeView(`object` as View)
        }


        // public CharSequence getPageTitle (int position)
        override fun getPageTitle(position: Int): CharSequence {
            return list[position]
        }



        // Generate random light hsv color
        private fun randomLightColor(lightPercent:Int,blackPercent:Int=100):Int{
            // Color variance - red, green, blue etc
            val hue = Random().nextInt(361).toFloat()

            // Color light to dark - 0 light 100 dark
            val saturation = lightPercent.toFloat()/100F

            // Color black to bright - 0 black 100 bright
            val brightness:Float = blackPercent.toFloat()/100F

            // Transparency level, full opaque
            val alpha = 255

            // Return the color
            return Color.HSVToColor(alpha,floatArrayOf(hue,saturation,brightness))
        }
    }

}
