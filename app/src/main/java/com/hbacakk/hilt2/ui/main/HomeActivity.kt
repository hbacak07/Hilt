package com.hbacakk.hilt2.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hbacakk.hilt2.R
import com.hbacakk.hilt2.util.UserManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), UserAdapter.UserListener {

    @Inject
    lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = UserAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.userListener = this
        adapter.setItems(listOf(
            "Ahmet", "Mehmet", "Tufan", "Tayfun", "Hasan", "Dilara", "Nuriye"
        ))

        //findViewById<TextView>(R.id.userDetailsTextView).text = "Username: ${userManager.getUsername()}\nPassword: ${userManager.getPassword()}"

    }

    override fun onUserSelected(user: String) {
        Toast.makeText(this, "Selected username: $user", Toast.LENGTH_SHORT).show()
    }
}