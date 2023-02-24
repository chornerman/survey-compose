package co.nimblehq.chorn.survey.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AppDimensions {
    val textInputBorderRadius = 10.dp
    val textInputHeight = 56.dp
    val textInputFontSize = 17.sp
    val textInputTrailingFontSize = 15.sp

    val submitButtonBorderRadius = 10.dp
    val submitButtonHeight = 56.dp
    val submitButtonFontSize = 17.sp
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }
