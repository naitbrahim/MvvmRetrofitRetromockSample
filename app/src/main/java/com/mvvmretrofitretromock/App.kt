package com.mvvmretrofitretromock

import android.app.Application
import com.mvvmretrofitretromock.network.NetworkingService

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        NetworkingService.init(this)
    }

}