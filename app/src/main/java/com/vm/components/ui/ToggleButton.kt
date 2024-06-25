package com.vm.components.ui
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vm.components.ui.theme.ComponentsTheme


@Composable
fun ToggleButton(value: Boolean, c: Color) {
var checked by remember { mutableStateOf(value) }
    ComponentsTheme {
        Box(modifier = Modifier) {
            Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            )
        }
    }
}

@Preview
@Composable
fun ViewSwitch() {
    ToggleButton(value = true, Color(0xFF707CDF))
}