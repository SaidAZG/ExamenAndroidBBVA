package com.example.examenandroidbbva.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    private val sessionKey = "is_logged_in"

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(sessionKey, false)
    }

    fun setUserLoggedIn(isLoggedIn: Boolean) {
        sharedPreferences.edit().putBoolean(sessionKey, isLoggedIn).apply()
    }
}