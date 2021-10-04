package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityResultBinding

class Result : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.UsernameResult.text = intent.getStringExtra(Constants.username)
        val correct = intent.getIntExtra(Constants.correct_Questions,0)
        val total = intent.getIntExtra(Constants.Total_Questions,0)
        binding.ScoreResult.text = "You have scored ${correct} out of ${total} "
        binding.FinishBtn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}