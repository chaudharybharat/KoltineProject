package com.example.bharat.kotlindemo

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.viewpager_activity.*
import mchehab.com.gridviewviewpager.GridViewAdapter
import mchehab.com.gridviewviewpager.ImageActivity

class ViewpagerActivity : AppCompatActivity() {

    val listImageURLs = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager_activity)

        addImageURLs()

        val gridViewAdapter = GridViewAdapter(this@ViewpagerActivity, listImageURLs)
        gridView.adapter = gridViewAdapter

        setGridViewOnItemClickListener()
    }

    private fun setGridViewOnItemClickListener(){
        gridView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@ViewpagerActivity, ImageActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("position", position)
            bundle.putStringArrayList("imageURLs", listImageURLs)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun addImageURLs() {
        listImageURLs.add("http://i.dailymail.co.uk/i/pix/2016/04/12/23/3319F89C00000578-3536787-image-m-19_1460498410943.jpg")
        listImageURLs.add("https://www.w3schools.com/css/img_forest.jpg")
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg")
        listImageURLs.add("https://www.w3schools.com/css/pineapple.jpg")
        listImageURLs.add("https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg")
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg")
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg")
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg")
        listImageURLs.add("https://www.w3schools.com/css/lights600x400.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-11.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-15.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-19.jpg")
        listImageURLs.add("https://cdn.spacetelescope.org/archives/images/thumb700x/heic1509a.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-12.jpg")
        listImageURLs.addAll(listImageURLs)
    }
}