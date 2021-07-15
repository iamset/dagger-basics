package com.example.jsonplaceholderdagger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jsonplaceholderdagger.BaseApplication
import com.example.jsonplaceholderdagger.R

import com.example.jsonplaceholderdagger.viewmodel.UserViewModel
import javax.inject.Inject

class UserActivity : AppCompatActivity() {


    @Inject lateinit var userViewModel: UserViewModel
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var  txtname: TextView
    lateinit var  txtemail: TextView
    lateinit var  txtusername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        txtname = findViewById(R.id.txt_name)
        txtemail = findViewById(R.id.txt_email)
        txtusername = findViewById(R.id.txt_username)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]
        userViewModel.getUser()
        userViewModel.mResponse.observe(this, Observer { user ->
           txtname.text = user.name
            txtusername.text = user.username
            txtemail.text = user.email

        })
    }
}