package com.vm.components.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.vm.components.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Roboto")

val fontFamily = FontFamily(
    Font(
        googleFont = fontName,
        fontProvider = provider,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    labelMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight(400),
        fontSize = 24.sp,
    ),
    labelLarge = TextStyle(
        fontSize = 40.sp,
        fontWeight = FontWeight(700),
        fontFamily = fontFamily,
    ),
    displayMedium = TextStyle(
        fontFamily = fontFamily, fontWeight = FontWeight.SemiBold/*...*/
    ),
)