package co.nimblehq.chorn.survey.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import co.nimblehq.chorn.survey.R

class AppStyles {

    private val neuzeitFontFamily = FontFamily(
        Font(R.font.neuzeit_regular, FontWeight.Normal),
        Font(R.font.neuzeit_bold, FontWeight.Bold)
    )

    private val normalText = TextStyle(
        fontFamily = neuzeitFontFamily,
        letterSpacing = 0.sp
    )

    private val boldText: TextStyle
        @Composable
        get() = normalText.copy(fontWeight = FontWeight.Bold)

    private val normal17Text: TextStyle
        @Composable
        get() = normalText.copy(fontSize = 17.sp)

    private val bold17Text: TextStyle
        @Composable
        get() = boldText.copy(fontSize = 17.sp)

    val whiteAlpha3Normal17Text: TextStyle
        @Composable
        get() = normal17Text.copy(color = Color.White.copy(alpha = 0.3f))

    val chineseBlackBold17Text: TextStyle
        @Composable
        get() = bold17Text.copy(color = ChineseBlack)
}

internal val LocalAppStyles = staticCompositionLocalOf { AppStyles() }
