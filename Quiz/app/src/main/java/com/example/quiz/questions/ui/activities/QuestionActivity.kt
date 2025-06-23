package com.example.quiz.questions.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.R
import com.example.quiz.main.ui.MainActivity
import com.example.quiz.questions.ui.preferences.QuizPreferences
import com.example.quiz.questions.ui.view_models.QuizViewModel
import com.example.quiz.results.ui.activities.ResultActivity

class QuestionActivity : AppCompatActivity() {
    private lateinit var preferences: QuizPreferences
    private lateinit var viewModel: QuizViewModel
    private lateinit var difficulty: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        difficulty = intent.getStringExtra("DIFFICULTY") ?: "easy"
        val questions = MainActivity.questions

        preferences = QuizPreferences(this)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(preferences, difficulty) as T
            }
        })[QuizViewModel::class.java]

        findViewById<Button>(R.id.exitButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }

        viewModel.currentScore.observe(this) { currentScore ->
            findViewById<TextView>(R.id.currentScoreTextView).text = "Текущий счёт: $currentScore"
        }

        val currentQuestionIndex = intent.getIntExtra("QUESTION_ID", 0)
        val question = questions[currentQuestionIndex]

        val progressText = findViewById<TextView>(R.id.progressText)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val progress = ((currentQuestionIndex) * 100 / questions.size)
        progressText.text = "Вопрос ${currentQuestionIndex + 1}/${questions.size}"
        progressBar.progress = progress

        findViewById<TextView>(R.id.questionTextView).text = question.text

        val radioGroup = findViewById<RadioGroup>(R.id.optionsRadioGroup)
        val correctAnswer = question.options[question.correctAnswerIndex]
        val shuffledOptions = question.options.shuffled()
        val shuffledAnswer = shuffledOptions.indexOf(correctAnswer)
        shuffledOptions.forEachIndexed { index, option ->
            val radioButton = RadioButton(this)
            radioButton.id = index
            radioButton.text = option
            radioGroup.addView(radioButton)
        }

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
                radioGroup.startAnimation(shake)
                Toast.makeText(this, "Выберите ответ!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (selectedId == shuffledAnswer) {
                viewModel.increaseScore(difficulty)
                Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
            }

            if (currentQuestionIndex < questions.size - 1) {
                val intent = Intent(this, QuestionActivity::class.java).apply {
                    putExtra("QUESTION_ID", currentQuestionIndex + 1)
                    putExtra("DIFFICULTY", difficulty)
                }
                startActivity(intent)
            } else {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("SCORE", viewModel.currentScore.value ?: 0)
                    putExtra("DIFFICULTY", difficulty)
                    putExtra("IS_NEW_RECORD", (viewModel.currentScore.value ?: 0) > (viewModel.highScore.value ?: 0))
                    viewModel.saveResults(difficulty)
                    putExtra("high_score_$difficulty", viewModel.highScore.value ?: 0)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                startActivity(intent)
                finish()
            }
        }
    }
}