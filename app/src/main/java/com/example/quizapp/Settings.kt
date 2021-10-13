package com.example.quizapp

import android.content.Intent

import android.content.SharedPreferences

import android.content.res.Configuration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val darkMode = findViewById<TextView>(R.id.darkmode)
        val back = findViewById<ImageView>(R.id.back)
        val changeName = findViewById<TextView>(R.id.changeName)

        val appSettingPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn: Boolean = appSettingPrefs.getBoolean("NightMode", false)

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            darkMode.text = "Disable Dark Mode"
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            darkMode.text = "Enable Dark Mode"
        }

        darkMode.setOnClickListener {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("NightMode", false)
                sharedPrefsEdit.apply()

                darkMode.text = "Enable Dark Mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefsEdit.putBoolean("NightMode", true)
                sharedPrefsEdit.apply()

                darkMode.text = "Disable Dark Mode"
            }
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_NO -> {
                    darkMode.text = "Enable Dark Mode"
                } // Night mode is not active, we're using the light theme
                Configuration.UI_MODE_NIGHT_YES -> {
                    darkMode.text = "Disable Dark Mode"
                } // Night mode is active, we're using dark theme

            }
            val username = intent.getStringExtra("username").toString()

            darkMode.setOnClickListener {
                val currentNightMode =
                    resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                when (currentNightMode) {
                    Configuration.UI_MODE_NIGHT_NO -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    } // Night mode is not active, we're using the light theme
                    Configuration.UI_MODE_NIGHT_YES -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    } // Night mode is active, we're using dark theme

                }
                onBackPressed()
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            onBackPressed()
//            val intent = Intent(this, Quiz_questions::class.java)
//            intent.putExtra("name",username)
//            startActivity(intent)
//            finish()

            }
            changeName.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            back.setOnClickListener {
                onBackPressed()
            }
        }
    }
}