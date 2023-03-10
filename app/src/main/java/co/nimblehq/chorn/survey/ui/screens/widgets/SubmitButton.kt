package co.nimblehq.chorn.survey.ui.screens.widgets

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import co.nimblehq.chorn.survey.ui.theme.AppTheme.dimensions
import co.nimblehq.chorn.survey.ui.theme.AppTheme.shapes
import co.nimblehq.chorn.survey.ui.theme.AppTheme.styles

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(dimensions.dp56),
        onClick = onClick,
        shape = shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(
            style = styles.chineseBlackBold17Text,
            text = text
        )
    }
}
