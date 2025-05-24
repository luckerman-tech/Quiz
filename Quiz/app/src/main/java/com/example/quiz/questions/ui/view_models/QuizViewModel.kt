package com.example.quiz.questions.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.questions.ui.preferences.QuizPreferences

class QuizViewModel(private val preferences: QuizPreferences) : ViewModel() {
    private val _score = MutableLiveData(preferences.getScore())
    val score: LiveData<Int> = _score

    fun increaseScore() {
        _score.value = _score.value?.plus(1)
        _score.value?.let { preferences.saveScore(it) }
    }
}