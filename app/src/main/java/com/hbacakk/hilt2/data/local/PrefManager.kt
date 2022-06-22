package com.hbacakk.hilt2.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PrefManager @Inject constructor(private val context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    var isUserLogged: Boolean
        get() = preferences.getBoolean("is_logged", false)
        set(value) {
            preferences.edit().putBoolean("is_logged", value).apply()
        }

    var username: String
        get() = preferences.getString("username", "") ?: ""
        set(value) {
            preferences.edit().putString("username", value).apply()
        }

    var password: String
        get() = preferences.getString("password", "") ?: ""
        set(value) {
            preferences.edit().putString("password", value).apply()
        }

}