package com.example.jsonplaceholderdagger.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholderdagger.model.User
import com.example.jsonplaceholderdagger.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {


    val mResponse: MutableLiveData<User> = MutableLiveData()
    fun getUser() {
        viewModelScope.launch {
            val response = userRepository.getUser()
            if(response.isSuccessful){
                mResponse.value = response.body()
                Log.d("Response", response.body()?.name.toString())
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        }
    }
}