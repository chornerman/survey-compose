package co.nimblehq.chorn.survey.ui.screens.login

import android.util.Patterns
import co.nimblehq.chorn.survey.domain.usecase.LoginUseCase
import co.nimblehq.chorn.survey.domain.usecase.LoginUseCase.*
import co.nimblehq.chorn.survey.ui.AppDestination
import co.nimblehq.chorn.survey.ui.base.BaseViewModel
import co.nimblehq.chorn.survey.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {

    private val _invalidInputError = MutableSharedFlow<Unit>()
    val invalidInputError: SharedFlow<Unit>
        get() = _invalidInputError

    fun login(email: String, password: String) {
        execute {
            showLoading()

            val input = LoginUseCaseInput(email, password)
            if (isInputValid(input)) {
                loginUseCase(input)
                    .catch { _error.emit(it) }
                    .collect { navigateToHome() }
            } else {
                _invalidInputError.emit(Unit)
            }

            hideLoading()
        }
    }

    private fun navigateToHome() {
        execute { _navigator.emit(AppDestination.Home) }
    }

    private fun isInputValid(input: LoginUseCaseInput): Boolean {
        val isEmailValid = input.email.isNotBlank()
        val isPasswordValid = input.password.isNotBlank()
        return isEmailValid && isPasswordValid
    }
}
