package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.quizapp.R

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val username = intent.getStringExtra("username").toString()
        val darkmode=findViewById(R.id.darkmode) as TextView
        val back=findViewById(R.id.back) as ImageView
        val changeName=findViewById(R.id.changeName) as TextView
        darkmode.setOnClickListener{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            onBackPressed()
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