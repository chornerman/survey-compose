package co.nimblehq.chorn.survey.domain.usecase

import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke(email: String): Flow<Unit> = repository.resetPassword(email)
}
