package com.example.ltdd_practice.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.ltdd_practice.ui.theme.Ltdd_practiceTheme

class TipCalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ltdd_practiceTheme {
                Surface {
                    TipCalculatorScreen()
                }
            }
        }
    }
}