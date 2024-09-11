package com.example.placar

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.placar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var playerOneScore : Int = 0
    private var playerTwoScore : Int = 0
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()

        if(savedInstanceState != null) {
            playerOneScore = savedInstanceState.getInt("PLAYER_ONE_SCORE")
            playerTwoScore = savedInstanceState.getInt("PLAYER_TWO_SCORE")
            setUpScorePlayerOne()
            setUpScorePlayerTwo()
        }
    }

    private fun setUpListeners() {
        binding.btPlayerOneScore.setOnClickListener{
            playerOneScore++
            setUpScorePlayerOne()
        }

        binding.btPlayerTwoScore.setOnClickListener{
            playerTwoScore++
            setUpScorePlayerTwo()
        }

        binding.btFinishMatch.setOnClickListener { finish() }

        binding.btRestart.setOnClickListener { restart() }
    }

    private fun restart() {
        playerOneScore = 0
        playerTwoScore = 0
        setUpScorePlayerOne()
        setUpScorePlayerTwo()
    }

    private fun setUpScorePlayerTwo() {
        binding.tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    private fun setUpScorePlayerOne() {
        binding.tvPlayerOneScore.text = playerOneScore.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PLAYER_ONE_SCORE", playerOneScore)
        outState.putInt("PLAYER_TWO_SCORE", playerTwoScore)
    }
}