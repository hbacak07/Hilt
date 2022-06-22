package com.hbacakk.hilt2.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.hbacakk.hilt2.R
import com.hbacakk.hilt2.util.UserManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (userManager.isUserLogged())
            startActivity(Intent(this, HomeActivity::class.java))

        findViewById<MaterialButton>(R.id.loginButton).setOnClickListener {
            val username = findViewById<EditText>(R.id.usernameEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()

            userManager.loginUser(
                username = username,
                password = password,
                successCallback = {
                    Toast.makeText(this, "User logged successfully!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                }, errorCallback = {
                    Toast.makeText(this, "Username or password wrong!", Toast.LENGTH_SHORT).show()
                })

        }

    }
}