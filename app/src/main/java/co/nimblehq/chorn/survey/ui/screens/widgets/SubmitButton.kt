package co.nimblehq.chorn.survey.ui.screens.widgets

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.nimblehq.chorn.survey.ui.theme.AppTheme.dimensions
import co.nimblehq.chorn.survey.ui.theme.ChineseBlack

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(dimensions.submitButtonHeight),
        onClick = onClick,
        shape = RoundedCornerShape(dimensions.submitButtonBorderRadius),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(
            text = text,
            color = ChineseBlack,
            fontSize = dimensions.submitButtonFontSize,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.sp
        )
    }
}
