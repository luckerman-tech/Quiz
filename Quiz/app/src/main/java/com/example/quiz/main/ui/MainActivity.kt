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
import com.example.quiz.data.models.Question
import com.example.quiz.questions.ui.activities.QuestionActivity
import com.example.quiz.questions.ui.preferences.QuizPreferences
import com.example.quiz.questions.ui.view_models.QuizViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: QuizPreferences
    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = QuizPreferences(this)
        updateRecords()

        val preferences = QuizPreferences(this)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(preferences, "") as T
            }
        })[QuizViewModel::class.java]

        findViewById<Button>(R.id.btnEasy).setOnClickListener {
            startQuiz("easy")
        }

        findViewById<Button>(R.id.btnMedium).setOnClickListener {
            startQuiz("medium")
        }

        findViewById<Button>(R.id.btnHard).setOnClickListener {
            startQuiz("hard")
        }

        findViewById<Button>(R.id.resetEasyHighScoreButton).setOnClickListener{
            viewModel.resetHighScore("easy")
            updateRecords(R.id.easyHighScoreTextView)
            Toast.makeText(this, "Рекорд легкого уровня сложности сброшен!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.resetMediumHighScoreButton).setOnClickListener{
            viewModel.resetHighScore("medium")
            updateRecords(R.id.mediumHighScoreTextView)
            Toast.makeText(this, "Рекорд среднего уровня сложности сброшен!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.resetHardHighScoreButton).setOnClickListener{
            viewModel.resetHighScore("hard")
            updateRecords(R.id.hardHighScoreTextView)
            Toast.makeText(this, "Рекорд сложного уровня сложности сброшен!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.resetAllHighScoresButton).setOnClickListener {
            viewModel.resetHighScore("easy")
            viewModel.resetHighScore("medium")
            viewModel.resetHighScore("hard")
            updateRecords()
            Toast.makeText(this, "Рекорды сброшены!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        QuizPreferences(this).saveScore(0)
        updateRecords()
    }

    private fun startQuiz(difficulty: String) {
        questions = QuestionsRepository.getQuestions(difficulty).shuffled()
        val intent = Intent(this, QuestionActivity::class.java).apply {
            putExtra("QUESTION_ID", 0)
            putExtra("DIFFICULTY", difficulty)
        }
        startActivity(intent)
    }

    private fun updateRecords(id: Int = -1) {
        findViewById<TextView>(R.id.easyHighScoreTextView).text = "Лёгкий: ${preferences.getHighScore("easy")}"
        findViewById<TextView>(R.id.mediumHighScoreTextView).text = "Средний: ${preferences.getHighScore("medium")}"
        findViewById<TextView>(R.id.hardHighScoreTextView).text = "Сложный: ${preferences.getHighScore("hard")}"

        if (id != -1) {
            findViewById<TextView>(id).animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(300)
                .withEndAction {
                    findViewById<TextView>(id).animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 300
                }
        }
        else {
            findViewById<TextView>(R.id.easyHighScoreTextView).animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(300)
                .withEndAction {
                    findViewById<TextView>(R.id.easyHighScoreTextView).animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 300
                }
            findViewById<TextView>(R.id.mediumHighScoreTextView).animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(300)
                .withEndAction {
                    findViewById<TextView>(R.id.mediumHighScoreTextView).animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 300
                }
            findViewById<TextView>(R.id.hardHighScoreTextView).animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(300)
                .withEndAction {
                    findViewById<TextView>(R.id.hardHighScoreTextView).animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 300
                }
        }
    }

    companion object {
        lateinit var questions: List<Question>
    }
}