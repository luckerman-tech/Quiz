package com.example.quiz.questions.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.R
import com.example.quiz.data.QuestionsRepository
import com.example.quiz.main.ui.MainActivity
import com.example.quiz.questions.ui.preferences.QuizPreferences
import com.example.quiz.questions.ui.view_models.QuizViewModel

class QuestionActivity : AppCompatActivity() {
    private lateinit var preferences: QuizPreferences
    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        preferences = QuizPreferences(this)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(preferences) as T
            }
        })[QuizViewModel::class.java]

        viewModel.currentScore.observe(this) { currentScore ->
            findViewById<TextView>(R.id.currentScoreTextView).text = "Текущий счёт: $currentScore"
        }

        val questionId = intent.getIntExtra("QUESTION_ID", 0)
        val questions = QuestionsRepository.getQuestions()
        val currentQuestionIndex = questions.indexOfFirst { it.id == questionId }
        val question = questions[currentQuestionIndex]

        findViewById<TextView>(R.id.questionTextView).text = question.text

        val radioGroup = findViewById<RadioGroup>(R.id.optionsRadioGroup)
        question.options.forEachIndexed { index, option ->
            val radioButton = RadioButton(this)
            radioButton.id = index
            radioButton.text = option
            radioGroup.addView(radioButton)
        }

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == question.correctAnswerIndex) {
                viewModel.increaseScore()
                Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
            }

            if (currentQuestionIndex < questions.size - 1) {
                val nextQuestion = questions[currentQuestionIndex + 1]
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("QUESTION_ID", nextQuestion.id)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Викторина завершена! Счёт: ${viewModel.currentScore.value}", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                intent.putExtra("SHOULD_UPDATE_HIGH_SCORE", true)
                startActivity(intent)
                viewModel.saveResults()
                finish()
            }
        }
    }
}