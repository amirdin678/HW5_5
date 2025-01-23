package com.example.hw5_m5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import java.util.prefs.Preferences
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        AcitvityMainBinding.inflate(layoutInflater)
    }


    @Inject
    lateinit var sharedPreferences: Preferences

    @Inject
    lateinit var loveApiService:LoveApiService

    @Inject
    lateinit var historyDao:HistoryDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        if (!sharedPreferences.isOnboardingComplete()) {
            sharedPreferences.SetOnboardingComplete(true)
        }else {
            navController.navigate(R.id.loveCalculatorFragment)
        }

        }
    }
