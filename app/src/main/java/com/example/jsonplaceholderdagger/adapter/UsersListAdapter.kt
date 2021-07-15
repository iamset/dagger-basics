package com.example.jsonplaceholderdagger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderdagger.R
import com.example.jsonplaceholderdagger.model.User

class UsersListAdapter(private val users: List<User>): RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtName:TextView
        val txtEmail:TextView
        val txtId:TextView

        init {
            txtName = view.findViewById(R.id.list_item_name)
            txtEmail = view.findViewById(R.id.list_item_email)
            txtId = view.findViewById(R.id.list_item_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.txtId.text = user.id.toString()
        holder.txtEmail.text = user.email
        holder.txtName.text = user.name

    }

    override fun getItemCount(): Int {
        return users.size
    }
}