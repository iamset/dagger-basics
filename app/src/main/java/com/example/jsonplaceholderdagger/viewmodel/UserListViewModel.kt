package com.example.jsonplaceholderdagger.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholderdagger.model.User
import com.example.jsonplaceholderdagger.repository.UserRepository
import kotlinx.coroutines.launch

import javax.inject.Inject

class UserListViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    val mResponse: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers(){
        viewModelScope.launch {
            val response = userRepository.getUsers()
            if(response.isSuccessful){
                mResponse.value = response.body()
                Log.d("Response", "Got data")
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        }
    }

}