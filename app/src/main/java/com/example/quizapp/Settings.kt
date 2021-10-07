package com.example.quizapp

import android.app.Activity
import android.content.Intent
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