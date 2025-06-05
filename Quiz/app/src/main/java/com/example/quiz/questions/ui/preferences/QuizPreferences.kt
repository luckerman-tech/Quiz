package com.example.quiz.questions.ui.preferences

import android.content.Context

class QuizPreferences(context: Context) {
    private val sharedPref = context.getSharedPreferences("QuizPrefs", Context.MODE_PRIVATE)

    fun saveScore(score: Int) {
        sharedPref.edit().putInt("SCORE", score).apply()
    }

    fun getScore(): Int = sharedPref.getInt("SCORE", 0)

    fun saveHighScore(difficulty: String, highScore: Int) {
        sharedPref.edit().putInt("high_score_$difficulty", highScore).apply()
    }

    fun getHighScore(difficulty: String): Int = sharedPref.getInt("high_score_$difficulty", 0)
}