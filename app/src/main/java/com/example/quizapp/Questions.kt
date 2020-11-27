package com.example.quizapp

data class Questions (
    val id:Int ,
    val question: String,
    val Image: Int,
    val op1:String,
    val op2:String,
    val op3:String,
    val op4:String,
    val correct:Int
)
