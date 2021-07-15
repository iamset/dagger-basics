package com.example.jsonplaceholderdagger.model

import javax.inject.Inject

data class  User @Inject constructor(
    val id:Int,
    val name:String,
    val email:String,
    val address:Address,
    val username:String,
    val phone:String,
    val website:String,
    val company:Company
        )