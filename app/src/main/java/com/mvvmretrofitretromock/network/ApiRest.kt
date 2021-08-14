package com.mvvmretrofitretromock.network

import com.mvvmretrofitretromock.network.responses.RespUsersList
import retrofit2.http.GET

interface ApiRest {

    @GET("/public/v1/users")
    suspend fun getUsers() : RespUsersList
}