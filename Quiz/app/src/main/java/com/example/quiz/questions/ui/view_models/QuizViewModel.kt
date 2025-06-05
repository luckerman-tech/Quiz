package com.example.quiz.questions.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.questions.ui.preferences.QuizPreferences

class QuizViewModel(private val preferences: QuizPreferences, difficulty: String) : ViewModel() {
    private val _currentScore = MutableLiveData(preferences.getScore())
    val currentScore: LiveData<Int> = _currentScore

    private val _highScore = MutableLiveData(preferences.getHighScore(difficulty))
    val highScore: LiveData<Int> = _highScore

    fun increaseScore(difficulty: String) {
        val points = when(difficulty) {
            "easy" -> 1
            "medium" -> 2
            "hard" -> 3
            else -> 1
        }
        _currentScore.value = _currentScore.value?.plus(points)
        preferences.saveScore(_currentScore.value ?: 0)
    }

    fun saveResults(difficulty: String) {
        val currentScoreValue = _currentScore.value ?: 0
        val highScoreValue = _highScore.value ?: 0

        if (currentScoreValue > highScoreValue) {
            _highScore.value = currentScoreValue
            preferences.saveHighScore(difficulty, currentScoreValue)
        }

        preferences.saveScore(0)
    }

    /*fun loadHighScore() {
        _highScore.value = preferences.getHighScore()
    }*/

    fun resetHighScore(difficulty: String) {
        //_highScore.value = 0
        preferences.saveHighScore(difficulty, 0)
    }
}