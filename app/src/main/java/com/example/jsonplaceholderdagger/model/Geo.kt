package com.example.jsonplaceholderdagger.model

import javax.inject.Inject

data class Geo @Inject constructor(
    val lat:String,
    val lng:String
)