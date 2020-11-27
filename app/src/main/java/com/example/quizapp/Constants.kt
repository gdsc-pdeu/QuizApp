package com.example.quizapp

object Constants {
    const val username :String = "user_name"
    const val Total_Questions: String = "total_questions"
    const val correct_Questions: String ="correct_answers"


    fun getQuestion(): ArrayList<Questions>{
        val questionsList   = ArrayList<Questions>()
        val que1 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_argentina,"India",
            "Australia","argentina","Spain",3)
        questionsList.add(que1)
        val que2 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_australia,"India",
            "Australia","Belgium","Spain",2)
        questionsList.add(que2)
        val que3 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_belgium,"Denmark",
            "Istanbul","Belgium","Fiji",3)
        questionsList.add(que3)
        val que4 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_brazil,"Brazil",
            "South Africa","argentina","Spain",1)
        questionsList.add(que4)
        val que5 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_denmark,"Denmark",
            "Greece","Sweden","Egypt",1)
        questionsList.add(que5)
        val que6 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_fiji,"India",
            "Srilanka","argentina","Fiji",4)
        questionsList.add(que6)
        val que7 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_germany,"USA",
            "Australia","Germany","Spain",3)
        questionsList.add(que7)
        val que8 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_india,"Newzealand",
            "India","ABC","You Know this",2)
        questionsList.add(que8)
        val que9 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_kuwait,"Greece",
            "Kuwait","UAE","Spain",2)
        questionsList.add(que9)
        val que10 = Questions(1,"What country does this belong to?",R.drawable.ic_flag_of_new_zealand,"NewZealand",
            "Australia","France","USA",1)
        questionsList.add(que10)

        return questionsList
    }

}