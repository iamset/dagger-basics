package com.example.jsonplaceholderdagger.model

import javax.inject.Inject

data class Address @Inject constructor (
    val street: String,
    val suite:String,
    val city:String,
    val zipcode:String,
    val geo:Geo
        )
