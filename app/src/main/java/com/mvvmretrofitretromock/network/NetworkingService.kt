package com.mvvmretrofitretromock.network

import android.content.Context
import co.infinum.retromock.Retromock
import com.google.gson.GsonBuilder
import com.mvvmretrofitretromock.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkingService {

    companion object {
        lateinit var apiRest: ApiRest
        lateinit var apiMock: ApiMock


        fun init(context: Context) {

            val json = GsonBuilder().setLenient().create()

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()


            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(json))
                .client(client)
                .build()

            val retromock: Retromock = Retromock.Builder()
                .retrofit(retrofit)
                .defaultBodyFactory(context.assets::open)
                .build()


            apiRest = retrofit.create(ApiRest::class.java)
            apiMock = retromock.create(ApiMock::class.java)
        }

    }

}