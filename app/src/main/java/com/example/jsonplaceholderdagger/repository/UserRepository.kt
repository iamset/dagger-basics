package com.example.jsonplaceholderdagger.repository

import android.util.Log
import com.example.jsonplaceholderdagger.api.UserApis
import com.example.jsonplaceholderdagger.model.User
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDataSource: UserApis) {

    suspend fun getUser(): Response<User> {
        return userDataSource.getUser()
    }

    suspend fun getUsers(): Response<List<User>>{
        return userDataSource.getUsers()
    }
}