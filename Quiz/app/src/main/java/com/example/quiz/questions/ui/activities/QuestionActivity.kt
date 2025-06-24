package com.example.quiz.questions.ui.activities

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.R
import com.example.quiz.main.ui.MainActivity
import com.example.quiz.questions.ui.preferences.QuizPreferences
import com.example.quiz.questions.ui.view_models.QuizViewModel
import com.example.quiz.results.ui.activities.ResultActivity
import com.example.quiz.sounds.SoundManager

class QuestionActivity : AppCompatActivity() {
    private lateinit var preferences: QuizPreferences
    private lateinit var viewModel: QuizViewModel
    private lateinit var difficulty: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        soundManager = SoundManager(this)

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
            radioButton.setTextColor(Color.parseColor("#000000"))
            radioButton.buttonTintList = ColorStateList(
                arrayOf(
                    intArrayOf(android.R.attr.state_checked),
                    intArrayOf(-android.R.attr.state_checked)
                ),
                intArrayOf(
                    Color.parseColor("#FF6200EE"),
                    Color.parseColor("#000000")
                )
            )
            radioGroup.addView(radioButton)
        }

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val toast = findViewById<TextView>(R.id.toastTextView)

            if (selectedId == -1) {
                val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
                radioGroup.startAnimation(shake)
                toast.text = "Выберите ответ!"
                toast.setTextColor(Color.parseColor("#FF9800"))
                return@setOnClickListener
            }
            if (selectedId == shuffledAnswer) {
                viewModel.increaseScore(difficulty)
                toast.text = "ПРАВИЛЬНО!"
                toast.setTextColor(Color.parseColor("#FF4CAF50"))
                findViewById<Button>(R.id.submitButton).visibility = View.GONE
                findViewById<Button>(R.id.exitButton).visibility = View.GONE
                radioGroup.forEach { button ->
                    button.isEnabled = false
                }
                soundManager.playSound("correct")
            } else {
                toast.text = "НЕПРАВИЛЬНО!"
                toast.setTextColor(Color.parseColor("#FFFF0000"))
                findViewById<Button>(R.id.submitButton).visibility = View.GONE
                findViewById<Button>(R.id.exitButton).visibility = View.GONE
                radioGroup.forEach { button ->
                    button.isEnabled = false
                }
                soundManager.playSound("wrong")
            }

            if (currentQuestionIndex < questions.size - 1) {
                val intent = Intent(this, QuestionActivity::class.java).apply {
                    putExtra("QUESTION_ID", currentQuestionIndex + 1)
                    putExtra("DIFFICULTY", difficulty)
                }
                Handler(Looper.getMainLooper()).postDelayed({startActivity(intent)}, 1000)
            } else {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("SCORE", viewModel.currentScore.value ?: 0)
                    putExtra("DIFFICULTY", difficulty)
                    putExtra("IS_NEW_RECORD", (viewModel.currentScore.value ?: 0) > (viewModel.highScore.value ?: 0))
                    viewModel.saveResults(difficulty)
                    putExtra("high_score_$difficulty", viewModel.highScore.value ?: 0)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    if (intent.getBooleanExtra("IS_NEW_RECORD", false)) {
                        soundManager.playSound("record")
                    }
                    else {
                        soundManager.playSound("completed")
                    }
                    startActivity(intent)
                    finish()}, 1000)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        soundManager.pause()
    }

    override fun onResume() {
        super.onResume()
        soundManager.resume()
    }

    companion object {
        lateinit var soundManager: SoundManager
    }
}