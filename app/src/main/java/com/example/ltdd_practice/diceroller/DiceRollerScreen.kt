package com.example.ltdd_practice.diceroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ltdd_practice.R
import kotlin.random.Random

@Composable
fun DiceRollerScreen() {

    var diceNumber by remember { mutableStateOf(1) }

    val diceImage = when (diceNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(diceImage),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { diceNumber = Random.nextInt(1, 7) }
        ) {
            Text("Roll")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Result: $diceNumber",
            style = MaterialTheme.typography.titleLarge
        )
    }
}
