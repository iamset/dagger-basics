package com.example.jsonplaceholderdagger.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jsonplaceholderdagger.viewmodel.UserListViewModel
import com.example.jsonplaceholderdagger.viewmodel.UserViewModel
import com.example.jsonplaceholderdagger.viewmodel.ViewModelFactory
import com.example.jsonplaceholderdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun UserViewModel(viewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    internal abstract fun UserListViewModel(viewModel: UserListViewModel): ViewModel

    //Add more ViewModels here
}