package com.example.ltdd_practice.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ltdd_practice.ui.theme.Ltdd_practiceTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ltdd_practiceTheme {
                BusinessCardScreen()
            }
        }
    }
}