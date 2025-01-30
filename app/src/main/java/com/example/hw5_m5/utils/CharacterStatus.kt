package com.example.hw5_m5.utils
enum class CharacterStatus(val colorResId: Int) {
    ALIVE(android.R.color.holo_green_light),
    DEAD(android.R.color.holo_red_light),
    UNKNOWN(android.R.color.darker_gray)
}