package com.vm.components.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vm.components.utils.generateAnimateColors
import com.vm.components.ui.theme.ComponentsTheme

data class InfoCardData(var value: Float, var label: String)
data class InfoCardColors(val normalColors: List<Color>, val warningColors: List<Color>)

enum class TemperatureScale { CELCIUS, FAHRENHEIT }
@Composable
fun InfoCard(data: InfoCardData, colors: InfoCardColors, scale: TemperatureScale) {
    val normalTemperatureRange = 90f..105f

    // Determine the target color based on the temperature
    val targetColors = if (data.value in normalTemperatureRange) {
        colors.normalColors
    } else {
        colors.warningColors
    }
    val label = when(scale) {
        TemperatureScale.CELCIUS ->  "C"
        TemperatureScale.FAHRENHEIT -> "F"
    }

    // Animate the border color based on temperature change
    val animatedColors = generateAnimateColors(colors = targetColors)


    ComponentsTheme {
        Box( modifier = Modifier
            .border(
                BorderStroke(5.dp, brush = Brush.linearGradient(animatedColors)),
                shape = RoundedCornerShape(16.dp),
            )

            .padding(start = 14.dp, top = 31.dp, end = 14.dp, bottom = 31.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text =  String.format("%.2f º%s", data.value, label),
                    style = MaterialTheme.typography.labelLarge,
                    color = animatedColors.first()
                )
                Text(
                    text = data.label,
                    style = MaterialTheme.typography.labelMedium,
                    color = animatedColors.first()
                )
            }
        }
    }
}

