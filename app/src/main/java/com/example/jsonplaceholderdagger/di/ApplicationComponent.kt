package com.example.jsonplaceholderdagger.di

import com.example.jsonplaceholderdagger.di.modules.NetworkModule
import com.example.jsonplaceholderdagger.di.modules.ViewModelModule
import com.example.jsonplaceholderdagger.view.UserActivity
import com.example.jsonplaceholderdagger.view.UsersListActivity

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {
    //This tells dagger that UserActivity requests injection
    fun inject(userActivity: UserActivity)
    fun inject(usersListActivity: UsersListActivity)
}