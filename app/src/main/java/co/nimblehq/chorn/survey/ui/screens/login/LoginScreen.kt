package co.nimblehq.chorn.survey.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                .fillMaxSize()
                .padding(top = 120.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_nimble),
                contentDescription = null
            )
            Spacer(Modifier.height(110.dp))
            TextInput(
                hintText = stringResource(id = R.string.login_email),
                value = email,
                onValueChanged = { email = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(Modifier.height(20.dp))
            TextInput(
                hintText = stringResource(R.string.login_password),
                value = password,
                onValueChanged = { password = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                trailingIcon = {
                    Text(
                        text = stringResource(R.string.login_forgot_password),
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = dimensions.textInputTrailingTextSize,
                        letterSpacing = 0.sp,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                // TODO: Navigate to Reset Password screen
                            }
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.height(20.dp))
            SubmitButton(
                text = stringResource(R.string.login),
                onClick = {
                    // TODO: Call LoginUseCase
                },
                modifier = Modifier.fillMaxWidth()
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
