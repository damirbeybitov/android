package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private var users: MutableList<User>, private val listener: (User) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return UserViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.textViewId).text = user.id.toString()
            findViewById<TextView>(R.id.textViewName).text = user.name
            findViewById<TextView>(R.id.textViewUsername).text = user.username
            findViewById<TextView>(R.id.textViewEmail).text = user.email
        }
        holder.itemView.setOnClickListener { listener(user) }
    }
    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }



    override fun getItemCount() = users.size

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
