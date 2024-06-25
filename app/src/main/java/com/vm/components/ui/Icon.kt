package com.vm.components.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vm.components.R
import kotlinx.serialization.Serializable

@Serializable
data class IconData(
    val iconResId: Int, val size: Float,
    val color: Long
)

@Composable
fun Icon(data: IconData) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .size(Dp(data.size))
    ) {
        Image(
            painter = painterResource(id = data.iconResId),
            contentDescription = "This is an icon",
            modifier = Modifier.size(Dp(data.size)),
            colorFilter = ColorFilter.tint(color = Color(data.color))
        )
    }
}

@Preview
@Composable
fun VewIcon () {
    val data:IconData = IconData(R.drawable.thermometer_simple, 32.2f, 0xFF707CDF )
    Icon(data = data)
}
