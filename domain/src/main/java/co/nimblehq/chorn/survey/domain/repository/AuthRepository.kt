package co.nimblehq.chorn.survey.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(email: String, password: String): Flow<Unit>

    fun resetPassword(email: String): Flow<Unit>
}
