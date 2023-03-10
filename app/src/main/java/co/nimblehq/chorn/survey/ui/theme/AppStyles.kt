package co.nimblehq.chorn.survey.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class AppStyles {

    private val normalText = TextStyle(
        fontFamily = NeuzeitFontFamily
    )

    private val normal17Text: TextStyle
        @Composable
        get() = normalText.copy(fontSize = 17.sp)

    val whiteNormal17Text: TextStyle
        @Composable
        get() = normal17Text.copy(color = Color.White)

    val whiteAlpha3Normal17Text: TextStyle
        @Composable
        get() = normal17Text.copy(color = Color.White.copy(alpha = 0.3f))
}

internal val LocalAppStyles = staticCompositionLocalOf { AppStyles() }
