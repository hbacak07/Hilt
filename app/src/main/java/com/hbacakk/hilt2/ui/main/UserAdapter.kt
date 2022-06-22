package com.hbacakk.hilt2.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hbacakk.hilt2.R

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    interface UserListener {
        fun onUserSelected(user: String)
    }

    private val list = mutableListOf<String>()
    var userListener: UserListener? = null

    class UserViewHolder constructor(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val usernameTextView = itemView.findViewById<TextView>(R.id.usernameTextView)
        fun bindItems(username: String, listener: UserListener?) {
            usernameTextView.text = username

            itemView.setOnClickListener {
                listener?.onUserSelected(username)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_names, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindItems(list[position], userListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItems(items: List<String>) {
        this.list.clear()
        this.list.addAll(items)
        notifyDataSetChanged()
    }
}