package com.example.m5lesson4_retrofitmvvm_rickandmortyapi.data.models


import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val characters: List<Character>? = null
)