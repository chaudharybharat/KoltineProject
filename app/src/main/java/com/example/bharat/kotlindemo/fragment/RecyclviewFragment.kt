package com.example.bharat.kotlindemo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bharat.kotlindemo.Adapter

import com.example.bharat.kotlindemo.R
import com.example.bharat.kotlindemo.modal.User
import kotlinx.android.synthetic.main.fragment_recyclview.*


class RecyclviewFragment : Fragment() {
    lateinit var userList: ArrayList<User>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniComponet();
    }

    private fun iniComponet() {
        userList = ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = Adapter(userList, context)
        addDummyData()
    }

    public fun addDummyData(){
        for (i in 1 until 10) {
            val user0 = User("Leo Elstin", "Kaniyakumari,TN")
            userList.add(user0)
            userList.add(User("Bat Man", "Gotham"))
            userList.add(User("Iorn Man", "New York"))
            userList.add(User("Thor", "Parallel universe"))
            userList.add(User("Loki", "Alien Planet"))
        }
        recyclerView.adapter.notifyDataSetChanged()
    }
}
