package com.example.quiz.results.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.R
import com.example.quiz.data.QuestionsRepository
import com.example.quiz.main.ui.MainActivity
import com.example.quiz.questions.ui.activities.QuestionActivity
import com.example.quiz.sounds.SoundManager

class ResultActivity : AppCompatActivity() {

    private lateinit var soundManager: SoundManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("SCORE", 0)
        val difficulty = intent.getStringExtra("DIFFICULTY") ?: "easy"
        soundManager = QuestionActivity.soundManager

        val rightPartLevelTextView = findViewById<TextView>(R.id.rightPartLevelTextView)
        val color = when(difficulty) {
            "easy" -> "#4CAF50"
            "medium" -> "#FFC107"
            "hard" -> "#F44336"
            else -> ""
        }

        val difficultyName = when(difficulty) {
            "easy" -> "лёгкий"
            "medium" -> "средний"
            "hard" -> "сложный"
            else -> ""
        }
        val highScore = intent.getIntExtra("high_score_$difficulty", 0)
        val isNewRecord = intent.getBooleanExtra("IS_NEW_RECORD", false)

        rightPartLevelTextView.text = difficultyName
        rightPartLevelTextView.setTextColor(Color.parseColor(color))
        findViewById<TextView>(R.id.scoreTextView).text = "Ваш счёт: $score"

        val highScoreText = if (isNewRecord) "⭐ Новый рекорд: $highScore ⭐" else "Рекорд: $highScore"
        findViewById<TextView>(R.id.highScoreTextView).text = highScoreText
        if (isNewRecord) {
            findViewById<TextView>(R.id.highScoreTextView).setTextColor(Color.parseColor("#FFD700"))
            val anim = AnimationUtils.loadAnimation(this, R.anim.pulse)
            findViewById<TextView>(R.id.highScoreTextView).startAnimation(anim)
        }

        findViewById<Button>(R.id.restartButton).setOnClickListener {
            MainActivity.questions = QuestionsRepository.getQuestions(difficulty).shuffled()
            startActivity(Intent(this, QuestionActivity::class.java).apply {
                putExtra("QUESTION_ID", 0)
                putExtra("DIFFICULTY", difficulty)
            })
            finish()
        }

        findViewById<Button>(R.id.mainMenuButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundManager.release()
    }

    override fun onPause() {
        super.onPause()
        soundManager.pause()
    }

    override fun onResume() {
        super.onResume()
        soundManager.resume()
    }
}