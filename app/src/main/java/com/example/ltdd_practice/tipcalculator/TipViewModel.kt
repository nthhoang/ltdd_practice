package com.example.ltdd_practice.tipcalculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.math.RoundingMode

class TipViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TipUiState())
    val uiState: StateFlow<TipUiState> = _uiState

    fun onBillChanged(raw: String) {
        // Cho phép nhập: số + 1 dấu '.' (hỗ trợ cả ',' -> '.')
        val normalized = raw.replace(',', '.')
        val cleaned = normalized.filterIndexed { index, c ->
            c.isDigit() || (c == '.' && normalized.indexOf('.') == index)
        }

        _uiState.update { it.copy(billInput = cleaned) }
    }

    private fun billAmount(): BigDecimal {
        val s = _uiState.value.billInput
        return s.toBigDecimalOrNullSafe() ?: BigDecimal.ZERO
    }

    fun tipAmount(): BigDecimal {
        val bill = billAmount()
        val rate = BigDecimal.valueOf(_uiState.value.tipRate)
        return bill.multiply(rate).setScale(2, RoundingMode.HALF_UP)
    }
}

private fun String.toBigDecimalOrNullSafe(): BigDecimal? =
    try { if (isBlank()) null else BigDecimal(this) } catch (_: Exception) { null }