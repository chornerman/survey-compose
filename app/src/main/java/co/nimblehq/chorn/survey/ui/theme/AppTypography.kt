package co.nimblehq.chorn.survey.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import co.nimblehq.chorn.survey.R

internal val NeuzeitFontFamily = FontFamily(
    Font(R.font.neuzeit_regular, FontWeight.Normal),
    Font(R.font.neuzeit_bold, FontWeight.Bold)
)

private val Typography = Typography(
    button = TextStyle(
        fontSize = 17.sp,
        fontFamily = NeuzeitFontFamily,
        fontWeight = FontWeight.Bold,
        color = ChineseBlack,
        letterSpacing = 0.sp
    )
)

internal val LocalAppTypography = staticCompositionLocalOf { Typography }
