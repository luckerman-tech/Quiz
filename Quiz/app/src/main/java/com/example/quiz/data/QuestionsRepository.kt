package com.example.quiz.data

import com.example.quiz.data.models.Question

object QuestionsRepository {
    fun getQuestions(): List<Question> = listOf(
        Question(
            id = 1,
            text = "Какая планета ближе всего к Солнцу?",
            options = listOf("Меркурий", "Венера", "Земля", "Марс"),
            correctAnswerIndex = 0
        ),
        Question(
            id = 2,
            text = "Какой язык программирования официальный для Android?",
            options = listOf("Java", "Python", "C++", "Kotlin"),
            correctAnswerIndex = 3
        ),
        // todo: make questions
    )
}