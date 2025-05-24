package com.example.quiz.main.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.R
import com.example.quiz.data.QuestionsRepository
import com.example.quiz.questions.ui.activities.QuestionActivity
import com.example.quiz.questions.ui.adapters.QuestionsAdapter
import com.example.quiz.questions.ui.preferences.QuizPreferences
import com.example.quiz.questions.ui.view_models.QuizViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = QuizPreferences(this)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(preferences) as T
            }
        })[QuizViewModel::class.java]

        viewModel.score.observe(this) { score ->
            findViewById<TextView>(R.id.titleTextView).text = "Викторина (Счёт: $score)"
        }

        val questions = QuestionsRepository.getQuestions()
        val adapter = QuestionsAdapter(questions) { question ->
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("QUESTION_ID", question.id)
            startActivity(intent)
        }

        findViewById<RecyclerView>(R.id.questionsRecyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }
}