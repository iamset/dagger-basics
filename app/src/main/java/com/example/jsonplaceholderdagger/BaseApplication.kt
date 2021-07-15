package com.example.jsonplaceholderdagger

import android.app.Application
import com.example.jsonplaceholderdagger.di.ApplicationComponent
import com.example.jsonplaceholderdagger.di.DaggerApplicationComponent

class BaseApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}