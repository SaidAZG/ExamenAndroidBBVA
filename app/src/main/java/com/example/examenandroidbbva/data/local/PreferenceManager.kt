package com.example.examenandroidbbva.data.local

import android.content.SharedPreferences
import com.example.examenandroidbbva.data.remote.model.LoginResponse
import com.google.gson.Gson
import javax.inject.Inject

class PreferenceManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    private val sessionKey = "is_logged_in"
    private val loginResponseKey = "login_response"
    private val gson = Gson()

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(sessionKey, false)
    }

    fun setUserLoggedIn(isLoggedIn: Boolean) {
        sharedPreferences.edit().putBoolean(sessionKey, isLoggedIn).apply()
    }

    fun saveLoginResponse(loginResponse: LoginResponse) {
        val json = gson.toJson(loginResponse)
        sharedPreferences.edit().putString(loginResponseKey, json).apply()
    }

    fun getLoginResponse(): LoginResponse? {
        val json = sharedPreferences.getString(loginResponseKey, null)
        return if (json != null) {
            gson.fromJson(json, LoginResponse::class.java)
        } else {
            null
        }
    }

    fun clearLoginResponse() {
        sharedPreferences.edit().remove(loginResponseKey).apply()
    }
}