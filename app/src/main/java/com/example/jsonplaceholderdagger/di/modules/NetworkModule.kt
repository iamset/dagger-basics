package com.example.jsonplaceholderdagger.di.modules

import com.example.jsonplaceholderdagger.api.UserApis
import com.example.jsonplaceholderdagger.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideUserRetrofitService(): UserApis {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApis::class.java)
    }


}