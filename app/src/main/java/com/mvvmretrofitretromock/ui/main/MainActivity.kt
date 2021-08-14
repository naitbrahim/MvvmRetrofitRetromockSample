package com.mvvmretrofitretromock.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvmretrofitretromock.R


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.myResponse.observe(this, Observer {
            for (oneUser in it.data!!){
                Log.d("responseid", oneUser.id.toString())
                Log.d("responsename", oneUser.name!!)
                Log.d("responseemail", oneUser.email!!)
                Log.d("responsegender", oneUser.gender!!)
                Log.d("responsestatus", oneUser.status!!)
            }
        })
        viewModel.getUsersOnline()

    }
}