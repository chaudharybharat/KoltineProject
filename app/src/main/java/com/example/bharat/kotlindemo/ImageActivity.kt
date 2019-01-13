package mchehab.com.gridviewviewpager

import kotlinx.android.synthetic.main.activity_image.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bharat.kotlindemo.R

class ImageActivity : AppCompatActivity() {

    var position = 0;
    var listImageURLs = arrayListOf<String>()
    val listFragments = arrayListOf<ImageFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        getArguments()
        initFragments()

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listFragments)
        viewPager.adapter = viewPagerAdapter
        viewPager.currentItem = position
    }

    private fun getArguments(){
        val bundle = intent.extras
        position = bundle.getInt("position")
        listImageURLs = bundle.getStringArrayList("imageURLs")
    }

    private fun initFragments(){
        for (i in 0..listImageURLs.size-1){
            val bundle = Bundle()
            val imageFragment = ImageFragment()
            bundle.putString("imageURL", listImageURLs[i])
            imageFragment.arguments = bundle
            listFragments.add(imageFragment)
        }
    }
}
