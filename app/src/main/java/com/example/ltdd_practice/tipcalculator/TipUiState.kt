package com.example.ltdd_practice.tipcalculator

data class TipUiState(
    val billInput: String = "",
    val tipRate: Double = 0.15 // 15% giống hình
)