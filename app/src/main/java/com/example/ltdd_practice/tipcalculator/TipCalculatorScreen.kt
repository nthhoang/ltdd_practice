package com.example.ltdd_practice.tipcalculator

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorScreen(
    modifier: Modifier = Modifier,
    vm: TipViewModel = viewModel()
) {
    val uiState by vm.uiState.collectAsState()

    val currency = remember { NumberFormat.getCurrencyInstance(Locale.US) }
    val tipText = remember(uiState.billInput) { currency.format(vm.tipAmount()) }

    // auto focus để hiện bàn phím
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) { focusRequester.requestFocus() }

    // Màu gần giống ảnh
    val pinkBg = Color(0xFFF2DDE2)      // nền textfield
    val pinkLine = Color(0xFFB0003A)    // gạch dưới + label

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 24.dp)
                // đẩy UI lên đúng vị trí như ảnh (không center)
                .padding(top = 140.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Calculate Tip",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(16.dp))

            TextField(
                value = uiState.billInput,
                onValueChange = vm::onBillChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                singleLine = true,
                label = { Text("Bill Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = pinkBg,
                    unfocusedContainerColor = pinkBg,
                    disabledContainerColor = pinkBg,

                    focusedIndicatorColor = pinkLine,
                    unfocusedIndicatorColor = pinkLine,

                    focusedLabelColor = pinkLine,
                    unfocusedLabelColor = pinkLine,

                    cursorColor = pinkLine
                )
            )

            // khoảng cách lớn như ảnh
            Spacer(Modifier.height(44.dp))

            Text(
                text = "Tip Amount: $tipText",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}