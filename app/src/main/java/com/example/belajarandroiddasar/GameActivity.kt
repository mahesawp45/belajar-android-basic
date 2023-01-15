package com.example.belajarandroiddasar

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockButton: ImageButton
    lateinit var paperButton: ImageButton
    lateinit var scissorsButton: ImageButton
    lateinit var resultImageView: ImageView
    lateinit var scoreTextView: TextView
    lateinit var highScoreTextView: TextView
    private var score: Int = 0
    private var highScore: Int = 0

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockButton = findViewById(R.id.rockButton)
        paperButton = findViewById(R.id.paperButton)
        scissorsButton = findViewById(R.id.scissorsButton)
        resultImageView = findViewById(R.id.resultImageView)
        scoreTextView = findViewById(R.id.scoreTextView)
        highScoreTextView = findViewById(R.id.highScoreTextView)
        scoreTextView.text = resources.getString(R.string.scoreTextView, score)
        highScoreTextView.text = resources.getString(R.string.highScoreTextView, highScore)
    }

    private fun initListeners() {
        rockButton.setOnClickListener {startGame("ROCK")}
        paperButton.setOnClickListener {startGame("PAPER")}
        scissorsButton.setOnClickListener {startGame("SCISSORS")}
    }

    private fun startGame(option: String) {
        val computersOption = Game.pickRandomOption()
        val drawable = Game.pickDrawable(computersOption)
        computerImageView.setImageResource(drawable)

        when {
            Game.isDraw(option, computersOption) -> {
                resultImageView.setImageResource(R.drawable.draw)
            }
            Game.isWin(option, computersOption) -> {
                resultImageView.setImageResource(R.drawable.win)
                score += 1
                scoreTextView.text = resources.getString(R.string.scoreTextView, score)
            }
            else -> {
                score -= 1
                scoreTextView.text = resources.getString(R.string.scoreTextView, score)
                resultImageView.setImageResource(R.drawable.lose)
            }
        }

        when {
            score >= highScore -> {
                highScore = score
                highScoreTextView.text = resources.getString(R.string.highScoreTextView, highScore)
            }
            else -> highScore
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()




    }
}