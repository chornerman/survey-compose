package co.nimblehq.chorn.survey.domain.usecase

import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {

    data class LoginUseCaseInput(
        val email: String,
        val password: String
    )

    operator fun invoke(input: LoginUseCaseInput): Flow<Unit> =
        repository.login(input.email, input.password)
}
