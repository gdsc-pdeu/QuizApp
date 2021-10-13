package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        binding.button.setOnClickListener{
            if (binding.editTextTextPersonName.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter the name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this,Quiz_questions::class.java)
                intent.putExtra(Constants.username,binding.editTextTextPersonName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}