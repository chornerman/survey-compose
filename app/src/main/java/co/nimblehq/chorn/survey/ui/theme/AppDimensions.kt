package co.nimblehq.chorn.survey.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

class AppDimensions {
    val dp20 = 20.dp
    val dp24 = 24.dp
    val dp56 = 56.dp
    val dp110 = 110.dp
    val dp120 = 120.dp
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }
