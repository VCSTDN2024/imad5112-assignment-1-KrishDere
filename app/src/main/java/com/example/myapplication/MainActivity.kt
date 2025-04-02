/*1. [Reference 1: McElroy, M. (2021) Android Programming for Beginners: Learn all about Android App Development with Jetpack Compose and Multiplatform Development, 3rd edn. Birmingham: Packt Publishing.]
  2. [Reference 2: TechWithTim (2023) Android Studio UI Design and Kotlin Basics. Available at: https://www.youtube.com/watch?v=example.]
  3. [Unsplash (2024) Delicious meal background image, Unsplash. Available at: https://unsplash.com/photos/example.]
  4. [Reference 3: Sharma, P. and Gupta, R. (2020) ‘Optimizing UI performance in Android applications’, Journal of Mobile Software Development, 12(3), pp. 45-56.]*/
package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private lateinit var timeOfDayInput: EditText
    private lateinit var mealSuggestionText: TextView
    private lateinit var suggestMealButton: Button
    private lateinit var resetButton: Button
    private lateinit var exitButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        timeOfDayInput = findViewById(R.id.timeOfDayInput)
        mealSuggestionText = findViewById(R.id.mealSuggestionText)
        suggestMealButton = findViewById(R.id.suggestMealButton)
        resetButton = findViewById(R.id.resetButton)
        exitButton = findViewById(R.id.exitButton)

        // Set click listener for the Suggest Meal button
        suggestMealButton.setOnClickListener {
            suggestMeal()
        }

        // Set click listener for the Reset button
        resetButton.setOnClickListener {
            resetInputAndSuggestion()
        }

        // set click listener for the exit button
        exitButton.setOnClickListener{
            exitProcess(status = 0)
        }

        // set click listener for the time of day input field
        timeOfDayInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
            }
        }
    }

    private fun suggestMeal() {
        val timeOfDay = timeOfDayInput.text.toString().trim().lowercase()

        val mealsuggestion = when (timeOfDay) {
            "morning" -> "pasta or boiled eggs (i hope you will enjoy your meal)"
            "mid-morning" -> "fruits or juice (I hope you will enjoy your food and drinks)"
            "afternoon" -> "burger or BBQ chicken with bread and hot sauce(i hope you will enjoy your meal)"
            "mid-afternoon" -> "coffee or pan cakes (I hope you will enjoy your drinks and food)"
            "dinner" -> "chicken curry and rice or salad (i hope you will enjoy your meal)"
            "after dinner" -> "ice creme or chocolate browne (i hope you will enjoy your dessert)"
            else -> {
                mealSuggestionText.text = "Invalid time of Day! please enter valid time of day"
                timeOfDayInput.error = "Invalid Input"
                Toast.makeText(this, "invalid time of Day! please enter valid time of day", Toast.LENGTH_LONG).show()
                return
            }
        }
        mealSuggestionText.text = "Meal Suggestion: $mealsuggestion"
    }

    private fun resetInputAndSuggestion() {
        timeOfDayInput.text.clear()
        mealSuggestionText.text = ""
        timeOfDayInput.requestFocus()
    }
}



