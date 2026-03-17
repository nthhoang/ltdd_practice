package com.example.ltdd_practice.woof

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun WoofScreen() {
    val dogs = remember { WoofData.dogs }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF3F4F1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            WoofTopBar()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 14.dp, end = 14.dp, bottom = 18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(dogs) { dog ->
                    DogItem(dog = dog)
                }
            }
        }
    }
}

@Composable
private fun WoofTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PawLogo(
            modifier = Modifier.size(36.dp)
        )

        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = "Woof",
            color = Color(0xFF222222),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
private fun DogItem(dog: Dog) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFDDE5DF)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = dog.imageUrl,
                contentDescription = dog.name,
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.size(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = dog.name,
                    color = Color(0xFF2D3436),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = dog.age,
                    color = Color(0xFF6D7471),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                imageVector = Icons.Rounded.KeyboardArrowDown,
                contentDescription = "Expand",
                tint = Color(0xFF5D675F),
                modifier = Modifier.size(22.dp)
            )
        }
    }
}

@Composable
private fun PawLogo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val mint = Color(0xFF9FD8BF)

            drawCircle(
                color = mint,
                radius = size.minDimension * 0.20f,
                center = Offset(size.width * 0.50f, size.height * 0.67f),
                style = Fill
            )

            drawCircle(
                color = mint,
                radius = size.minDimension * 0.11f,
                center = Offset(size.width * 0.25f, size.height * 0.34f),
                style = Fill
            )

            drawCircle(
                color = mint,
                radius = size.minDimension * 0.11f,
                center = Offset(size.width * 0.42f, size.height * 0.20f),
                style = Fill
            )

            drawCircle(
                color = mint,
                radius = size.minDimension * 0.11f,
                center = Offset(size.width * 0.62f, size.height * 0.22f),
                style = Fill
            )

            drawCircle(
                color = mint,
                radius = size.minDimension * 0.11f,
                center = Offset(size.width * 0.78f, size.height * 0.36f),
                style = Fill
            )
        }
    }
}