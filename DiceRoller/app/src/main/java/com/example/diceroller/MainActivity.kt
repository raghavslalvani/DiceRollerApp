package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    // Roll the dice and Update the screen with the result
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the Dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView1)
        // Determine which Resource ID to use based on dice Roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_11
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with correct drawable Resource ID
        diceImage.setImageResource(drawableResource)
        // Update the content Description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}