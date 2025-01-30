package com.example.hw5_m5.data

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.hw5_m5.data.db.CharacterDatabase
import com.example.hw5_m5.data.db.api.CartoonApiService
import com.example.hw5_m5.data.db.api.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences): com.example.hw5_m5.utils.SharedPreferences {
        return com.example.hw5_m5.utils.SharedPreferences(
            sharedPreferences
        )
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(
        retrofit: Retrofit
    ): CartoonApiService {
        return retrofit.create(CartoonApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesCharacterDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun provideCharacterDao(database: CharacterDatabase): CharacterDao {
        return database.charactersDao()
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
 }