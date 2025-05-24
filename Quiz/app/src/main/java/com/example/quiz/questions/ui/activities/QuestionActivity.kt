package com.example.quiz.questions.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.R
import com.example.quiz.data.QuestionsRepository
import com.example.quiz.questions.ui.view_models.QuizViewModel

class QuestionActivity : AppCompatActivity() {
    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        viewModel = ViewModelProvider(this)[QuizViewModel::class.java]

        val questionId = intent.getIntExtra("QUESTION_ID", 0)
        val question = QuestionsRepository.getQuestions().first { it.id == questionId }

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
                Toast.makeText(this, "Правильно!! Счёт: ${viewModel.score.value}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}