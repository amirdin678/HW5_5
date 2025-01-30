package com.example.hw5_m5.utils

import com.example.hw5_m5.data.model.CharacterEntity
import com.example.m5lesson4_retrofitmvvm_rickandmortyapi.data.models.Character

interface OnItemClick {
    fun onItemClick(character: Character){
        println()
    }
    fun onItemClick(character: CharacterEntity){
        println()
    }
}