package com.example.quiz.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.example.quiz.R

class SoundManager(private val context: Context) {
    private var soundPool: SoundPool
    private var currentStreamId: Int? = null
    private val sounds = mutableMapOf<String, Int>()

    init {
        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .setAudioAttributes(attributes)
            .build()

        sounds["correct"] = soundPool.load(context, R.raw.correct_answer, 1)
        sounds["wrong"] = soundPool.load(context, R.raw.wrong_answer, 1)
        sounds["completed"] = soundPool.load(context, R.raw.completed, 1)
        sounds["record"] = soundPool.load(context, R.raw.new_record, 1)
    }

    fun playSound(type: String) {
        val soundId = sounds[type] ?: return
        currentStreamId = soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    fun release() {
        soundPool.release()
    }

    fun pause() {
        currentStreamId?.let { streamId ->
            soundPool.pause(streamId)
        }
    }

    fun resume() {
        currentStreamId?.let { streamId ->
            soundPool.resume(streamId)
        }
    }
}