package com.mvvmretrofitretromock.repositories

import com.mvvmretrofitretromock.network.responses.RespUsersList
import com.mvvmretrofitretromock.network.NetworkingService

class UserRepository {
    

    suspend fun getUsers(offline: Boolean?): RespUsersList {

        if (offline == true)
            return NetworkingService.apiMock.getUsers()
        else
            return NetworkingService.apiRest.getUsers()
    }
}