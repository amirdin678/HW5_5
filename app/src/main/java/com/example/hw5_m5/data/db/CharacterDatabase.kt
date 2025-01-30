package com.example.hw5_m5.data.db

import androidx.room.Database
    import androidx.room.RoomDatabase
    import com.example.hw5_m5.data.db.api.CharacterDao
    import com.example.hw5_m5.data.model.CharacterEntity


    @Database(entities = [CharacterEntity::class], version = 4)
    abstract class CharacterDatabase : RoomDatabase() {

        abstract fun charactersDao(): CharacterDao
    }