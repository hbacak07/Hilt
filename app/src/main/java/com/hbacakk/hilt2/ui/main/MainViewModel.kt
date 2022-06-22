package com.hbacakk.hilt2.ui.main

import androidx.lifecycle.ViewModel
import com.hbacakk.hilt2.util.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var userManager: UserManager

    fun loginUser() {

    }

}