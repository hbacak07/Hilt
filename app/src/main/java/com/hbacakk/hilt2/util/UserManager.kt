package com.hbacakk.hilt2.util

import android.content.Context
import android.util.Log
import com.hbacakk.hilt2.data.local.PrefManager
import javax.inject.Inject

class UserManager @Inject constructor(
    private val context: Context,
    private val prefManager: PrefManager
) {

    private val TAG = "UserManager"

    fun loginUser(
        username: String,
        password: String,
        successCallback: () -> Unit,
        errorCallback: () -> Unit
    ) {
        if (username == "hasan" && password == "bacak") {
            Log.d(TAG, "User logged in successfully.")

            prefManager.isUserLogged = true
            prefManager.username = username
            prefManager.password = password

            successCallback()
        } else {
            errorCallback()
        }
    }

    fun getUsername(): String = prefManager.username

    fun getPassword(): String = prefManager.password

    fun isUserLogged() : Boolean = prefManager.isUserLogged

}