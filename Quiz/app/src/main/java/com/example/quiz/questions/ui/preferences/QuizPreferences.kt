package com.example.quiz.questions.ui.preferences

import android.content.Context

class QuizPreferences(context: Context) {
    private val sharedPref = context.getSharedPreferences("QuizPrefs", Context.MODE_PRIVATE)

    fun saveScore(score: Int) {
        sharedPref.edit().putInt("SCORE", score).apply()
    }

    fun getScore(): Int = sharedPref.getInt("SCORE", 0)

    fun saveHighScore(highScore: Int) {
        sharedPref.edit().putInt("HIGH_SCORE", highScore).apply()
    }

    fun getHighScore(): Int = sharedPref.getInt("HIGH_SCORE", 0)
}