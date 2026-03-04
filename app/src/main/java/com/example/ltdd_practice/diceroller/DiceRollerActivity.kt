package com.example.ltdd_practice.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ltdd_practice.ui.theme.Ltdd_practiceTheme

class DiceRollerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ltdd_practiceTheme {
                DiceRollerScreen()
            }
        }
    }
}