package com.vm.components.utils

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color

@Composable
fun generateAnimateColors(colors: List<Color>): List<Color> {
    var animatedColor: MutableList<Color> = mutableListOf()
    colors.forEach {
         animatedColor.add(generateColor(it))
    }
    return animatedColor
}

@Composable
fun generateColor(inColor: Color): Color {
    val animatedColor by animateColorAsState(
        targetValue = inColor,
        animationSpec = tween(3000)
    )
    return animatedColor
}
