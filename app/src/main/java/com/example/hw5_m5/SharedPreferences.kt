package com.example.hw5_m5

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val SHOWN = "shown"
    }

    fun isOnBoardingComplete(): Boolean {
        return sharedPreferences.getBoolean(SHOWN, false)
    }

    fun  setOnBoardingComplete() {
        sharedPreferences.edit().putBoolean(SHOWN, false).apply()
    }
}