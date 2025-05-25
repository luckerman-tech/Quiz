package com.example.quiz.questions.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.questions.ui.preferences.QuizPreferences

class QuizViewModel(private val preferences: QuizPreferences) : ViewModel() {
    private val _currentScore = MutableLiveData(preferences.getScore())
    val currentScore: LiveData<Int> = _currentScore

    private val _highScore = MutableLiveData(preferences.getHighScore())
    val highScore: LiveData<Int> = _highScore

    fun increaseScore() {
        _currentScore.value = _currentScore.value?.plus(1)
        preferences.saveScore(_currentScore.value ?: 0)
    }

    fun saveResults() {
        val currentScoreValue = _currentScore.value ?: 0
        val highScoreValue = _highScore.value ?: 0

        if (currentScoreValue > highScoreValue) {
            _highScore.value = currentScoreValue
            preferences.saveHighScore(currentScoreValue)
        }

        preferences.saveScore(0)
    }

    fun loadHighScore() {
        _highScore.value = preferences.getHighScore()
    }

    fun resetHighScore() {
        _highScore.value = 0
        preferences.saveHighScore(0)
    }
}