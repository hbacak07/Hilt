package com.hbacakk.hilt2.util

import android.util.Log
import javax.inject.Inject

class EnglishPerson @Inject constructor(): Person {

    private val TAG: String = "EnglishPerson"

    override fun speakLanguage() {
        Log.d(TAG, "Person is ready to speaking english.")



    }

}