package com.example.bharat.kotlindemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.bharat.kotlindemo.fragment.RecyclviewFragment
import com.example.bharat.kotlindemo.fragment.ViewpagerFragment
import com.example.bharat.kotlindemo.modal.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {




    lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // tv_recyclviewdemo.setOnClickListener(this)
        val tv_recyclviewdemo: TextView = findViewById(R.id.tv_recyclviewdemo)
        tv_recyclviewdemo.setOnClickListener(this)
        tv_viewpager.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        val TvValue: String

        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        when (v.id) {

            R.id.tv_recyclviewdemo -> {
                val beginTransaction = supportFragmentManager
                        .beginTransaction()
                beginTransaction.add(R.id.container, RecyclviewFragment(), "recyclview")
                        .commit()
            }
            R.id.tv_viewpager -> {
             /*   val intent = Intent(this, ViewpagerActivity::class.java)
              //  intent.putExtra("keyIdentifier", value)
                startActivity(intent)*/

                val beginTransaction = supportFragmentManager
                        .beginTransaction()
                beginTransaction.add(R.id.container, ViewpagerFragment(), "recyclview")
                        .commit()
            }

        }

    }

}

