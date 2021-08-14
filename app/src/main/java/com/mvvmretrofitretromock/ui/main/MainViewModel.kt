package com.mvvmretrofitretromock.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.mvvmretrofitretromock.network.responses.RespUsersList
import com.mvvmretrofitretromock.repositories.UserRepository

class MainViewModel : ViewModel() {

    private val repo : UserRepository = UserRepository()
    val myResponse: MutableLiveData<RespUsersList> = MutableLiveData()

    fun getUsersOffline() {
        viewModelScope.launch {
            val response = repo.getUsers(true)
            myResponse.value = response
        }
    }

    fun getUsersOnline() {
        viewModelScope.launch {
            val response = repo.getUsers(false)
            myResponse.value = response
        }
    }

}