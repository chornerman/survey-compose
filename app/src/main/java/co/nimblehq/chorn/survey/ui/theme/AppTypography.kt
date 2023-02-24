package co.nimblehq.chorn.survey.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.*
import co.nimblehq.chorn.survey.R

private val NeuzeitFontFamily = FontFamily(
    Font(R.font.neuzeit_bold, FontWeight.Bold),
    Font(R.font.neuzeit_regular, FontWeight.Normal)
)

private val Typography = Typography(
    defaultFontFamily = NeuzeitFontFamily
)

internal val LocalAppTypography = staticCompositionLocalOf { Typography }
