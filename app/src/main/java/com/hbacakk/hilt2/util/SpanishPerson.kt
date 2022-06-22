package com.hbacakk.hilt2.util

import android.util.Log
import javax.inject.Inject

class SpanishPerson @Inject constructor(val englishPerson: EnglishPerson) :Person {

    private val TAG = "SpanishPerson"

    override fun speakLanguage() {
        Log.d(TAG, "Person ready to speaking spanish.")
    }
}