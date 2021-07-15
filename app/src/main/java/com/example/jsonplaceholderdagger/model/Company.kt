package com.example.jsonplaceholderdagger.model

import javax.inject.Inject

data class Company @Inject constructor (
    val name:String,
    val catchPhrase:String,
    val bs:String
        )