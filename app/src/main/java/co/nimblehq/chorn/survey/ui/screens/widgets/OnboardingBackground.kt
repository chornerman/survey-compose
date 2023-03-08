package co.nimblehq.chorn.survey.ui.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import co.nimblehq.chorn.survey.R

@Composable
fun OnboardingBackground() {
    Image(
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(R.drawable.bg_onboarding_blurred),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}
