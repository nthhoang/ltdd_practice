package com.example.ltdd_practice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ltdd_practice.businesscard.BusinessCardActivity
import com.example.ltdd_practice.diceroller.DiceRollerActivity
import com.example.ltdd_practice.tipcalculator.TipCalculatorActivity
import com.example.ltdd_practice.ui.theme.Ltdd_practiceTheme
import com.example.ltdd_practice.woof.WoofActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ltdd_practiceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Danh sách bài tập",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Button(
                            onClick = {
                                startActivity(
                                    Intent(this@MainActivity, BusinessCardActivity::class.java)
                                )
                            }
                        ) {
                            Text("Bài 1 - Business Card")
                        }

                        Button(
                            onClick = {
                                startActivity(
                                    Intent(this@MainActivity, DiceRollerActivity::class.java)
                                )
                            }
                        ) {
                            Text("Bài 2 - Dice Roller")
                        }

                        Button(
                            onClick = {
                                startActivity(
                                    Intent(this@MainActivity, TipCalculatorActivity::class.java)
                                )
                            }
                        ) {
                            Text("Bài 3 - Tip Calculator")
                        }

                        Button(
                            onClick = {
                                startActivity(Intent(this@MainActivity, WoofActivity::class.java))
                            }
                        ) {
                            Text("Bài Woof")
                        }
                    }
                }
            }
        }
    }
}