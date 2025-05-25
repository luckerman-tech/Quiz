package com.example.quiz.main.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.R
import com.example.quiz.data.QuestionsRepository
import com.example.quiz.questions.ui.activities.QuestionActivity
import com.example.quiz.questions.ui.preferences.QuizPreferences
import com.example.quiz.questions.ui.view_models.QuizViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = QuizPreferences(this)
        preferences.saveScore(0)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(preferences) as T
            }
        })[QuizViewModel::class.java]

        if (intent?.getBooleanExtra("SHOULD_UPDATE_HIGH_SCORE", false) == true) {
            viewModel.loadHighScore()
        }

        viewModel.highScore.observe(this) { highScore ->
            findViewById<TextView>(R.id.scoreTextView).text = "Рекорд: $highScore"
        }

        findViewById<Button>(R.id.startButton).setOnClickListener {
            startQuiz()
        }

        findViewById<Button>(R.id.resetHighScoreButton).setOnClickListener {
            viewModel.resetHighScore()
            Toast.makeText(this, "Рекорд сброшен!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startQuiz() {
        val questions = QuestionsRepository.getQuestions()
        if (questions.isNotEmpty()) {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("QUESTION_ID", questions[0].id)
            startActivity(intent)
        }
    }
}