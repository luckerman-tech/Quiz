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

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("SCORE", 0)
        val difficulty = intent.getStringExtra("DIFFICULTY") ?: "easy"

        val difficultyName = when(difficulty) {
            "easy" -> "лёгкий"
            "medium" -> "средний"
            "hard" -> "сложный"
            else -> ""
        }
        //val highScore = intent.getIntExtra("HIGH_SCORE", 0)
        val highScore = intent.getIntExtra("high_score_$difficulty", 0)
        val isNewRecord = intent.getBooleanExtra("IS_NEW_RECORD", false)

        //findViewById<TextView>(R.id.scoreTextView).text = "Правильных ответов: $score"
        findViewById<TextView>(R.id.scoreTextView).text = """
            Викторина завершена!
            Уровень: $difficultyName
            Ваш счёт: $score
        """.trimIndent()

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
}