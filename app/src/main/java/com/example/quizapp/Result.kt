package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.hide()
        Username_result.text = intent.getStringExtra(Constants.username)
        val correct = intent.getIntExtra(Constants.correct_Questions,0)
        val total = intent.getIntExtra(Constants.Total_Questions,0)
        Score_result.text = "You have scored ${correct} out of ${total} "
        Finish_btn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}