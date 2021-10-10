package com.example.quizapp

import android.app.Activity
import android.content.Intent

import android.content.SharedPreferences

import android.content.res.Configuration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import com.example.quizapp.R

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val darkMode=findViewById(R.id.darkmode) as TextView
        val back=findViewById(R.id.back) as ImageView
        val changeName=findViewById(R.id.changeName) as TextView

        val appSettingPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn: Boolean = appSettingPrefs.getBoolean("NightMode", false)

        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            darkMode.text = "Disable Dark Mode"
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                darkMode.text = "Enable Dark Mode"
        }

        darkMode.setOnClickListener{
            if(isNightModeOn){
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

        val darkmode=findViewById(R.id.darkmode) as TextView
        val currentNightMode =   resources.configuration.uiMode and  Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {
                darkmode.text = "Enable Dark Mode"
            } // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {
                darkmode.text = "Disable Dark Mode"
            } // Night mode is active, we're using dark theme

        }
        val username = intent.getStringExtra("username").toString()

        val back=findViewById(R.id.back) as ImageView
        val changeName=findViewById(R.id.changeName) as TextView
        darkmode.setOnClickListener{
            val currentNightMode =   resources.configuration.uiMode and  Configuration.UI_MODE_NIGHT_MASK
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
        changeName .setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        back.setOnClickListener{
           onBackPressed()
        }
    }
}