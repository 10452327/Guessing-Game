package com.st10452327.guessingnumberapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var editTExtGuess: EditText
    private lateinit var buttonGuess: Button
    private lateinit var textViewResult: TextView

    private var randomNumber = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate a random number between 1 and 100
        randomNumber = Random.nextInt(1,100)

        editTExtGuess = findViewById(R.id.editTextGuess)
        buttonGuess = findViewById(R.id.buttonGuess)
        textViewResult = findViewById(R.id.textViewResult)

        buttonGuess.setOnClickListener{
            checkGuess()
        }
    }

    private fun checkGuess(){
        val guess = editTExtGuess.text.toString().toIntOrNull()

        if (guess == null){
            Toast.makeText(this,"Please enter a valid number", Toast.LENGTH_SHORT).show()
            return
        }

        when {
            guess == randomNumber -> textViewResult.text = "Congratulations! You guessed the correct number,"
            guess < randomNumber -> textViewResult.text = "Try again. The number is greater than $guess,"
            guess > randomNumber -> textViewResult.text = "Tyr again. The number is less than $guess"
        }
    }
}