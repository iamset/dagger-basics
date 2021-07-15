package com.example.jsonplaceholderdagger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderdagger.BaseApplication
import com.example.jsonplaceholderdagger.R
import com.example.jsonplaceholderdagger.adapter.UsersListAdapter
import com.example.jsonplaceholderdagger.model.User
import com.example.jsonplaceholderdagger.viewmodel.UserListViewModel
import com.example.jsonplaceholderdagger.viewmodel.UserViewModel
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    @Inject
    lateinit var userListViewModel:UserListViewModel
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var users: List<User>
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as BaseApplication).appComponent.inject(this)
        setContentView(R.layout.activity_users_list)

        recyclerView = findViewById(R.id.rv_users)


        userListViewModel = ViewModelProvider(this, viewModelFactory)[userListViewModel::class.java]
        userListViewModel.getUsers()
        userListViewModel.mResponse.observe(this, Observer {
            val adapter = UsersListAdapter(it)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        })
    }
}