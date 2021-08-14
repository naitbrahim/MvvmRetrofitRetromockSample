package com.mvvmretrofitretromock.network

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockBehavior
import co.infinum.retromock.meta.MockResponse
import com.mvvmretrofitretromock.network.responses.RespUsersList
import retrofit2.http.GET

interface ApiMock {

    @MockResponse(body = "users.json")
    @Mock
    @MockBehavior(durationMillis = 2000, durationDeviation = 3000)
    @GET("/")
    suspend fun getUsers(): RespUsersList
}