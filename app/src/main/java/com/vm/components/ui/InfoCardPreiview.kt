package com.vm.components.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun InfoCardPreview() {
    val normalColors =  listOf(
        Color(0xFF707DDE),
        Color(0xFF6E78D9),
        Color(0xFF3D4357)
    )
    val warningColors = listOf(
        Color(0xFFB84C45),
        Color(0x95C95850),
        Color(0x54573D43)
    )
    val colors = InfoCardColors(normalColors, warningColors)
    var value by remember {
        mutableStateOf(95f)
    }
    val info = InfoCardData( value, "Temperature")
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        // TemperatureBox with initial temperature

        InfoCard(data=info, colors, TemperatureScale.CELCIUS)

        Spacer(modifier = Modifier.height(16.dp))

        // Button to simulate temperature change
        Button(onClick = {
            value = if (value == 95f) 110f else 95f
        }) {
            Text("Toggle Temperature")
        }
    }
}