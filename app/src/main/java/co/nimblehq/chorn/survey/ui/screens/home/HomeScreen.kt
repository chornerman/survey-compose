package co.nimblehq.chorn.survey.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import co.nimblehq.chorn.survey.ui.AppDestination

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: (destination: AppDestination) -> Unit
) {
}
