package com.example.ltdd_practice.businesscard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.ltdd_practice.R

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.7f))

        ProfileSection()

        Spacer(modifier = Modifier.weight(1f))

        ContactSection()
    }
}


@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.logo_android),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nguyễn Tam Huy Hoàng",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Android Developer",
            fontSize = 18.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp), // 👈 đẩy lên khỏi đáy
        contentAlignment = Alignment.Center
    ) {
        Column {
            ContactRow(Icons.Default.Phone, "0379 799 593")
            ContactRow(Icons.Default.Email, "hoangnth.24it@vku.udn.vn")
            ContactRow(Icons.Filled.Home, "hoangnth.com")
        }
    }
}


@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF3DDC84))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
}
