package co.nimblehq.chorn.survey.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import co.nimblehq.chorn.survey.R
import co.nimblehq.chorn.survey.ui.AppDestination
import co.nimblehq.chorn.survey.ui.screens.widgets.*
import co.nimblehq.chorn.survey.ui.theme.*
import co.nimblehq.chorn.survey.ui.theme.AppTheme.dimensions

@Composable
fun LoginScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: (destination: AppDestination) -> Unit
) {
    LoginScreenContent()
}

@Composable
private fun LoginScreenContent() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box {
        OnboardingBackground()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensions.dp120,
                    start = dimensions.dp24,
                    end = dimensions.dp24
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_nimble),
                contentDescription = null
            )
            TextInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensions.dp110),
                hintText = stringResource(id = R.string.login_email),
                value = email,
                onValueChanged = { email = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            TextInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensions.dp20),
                hintText = stringResource(R.string.login_password),
                value = password,
                onValueChanged = { password = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            SubmitButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensions.dp20),
                text = stringResource(R.string.login),
                onClick = {
                    // TODO: Call LoginUseCase through ViewModel
                }
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    ComposeTheme {
        LoginScreenContent()
    }
}
