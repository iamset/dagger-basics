package com.example.jsonplaceholderdagger.api

import com.example.jsonplaceholderdagger.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApis {
    @GET("users/1")
    suspend fun getUser(): Response<User>

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}