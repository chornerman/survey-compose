package co.nimblehq.chorn.survey.data.repository

import co.nimblehq.chorn.survey.data.extensions.flowTransform
import co.nimblehq.chorn.survey.data.request.LoginRequest
import co.nimblehq.chorn.survey.data.response.toToken
import co.nimblehq.chorn.survey.data.service.AuthService
import co.nimblehq.chorn.survey.data.service.ApiCredential
import co.nimblehq.chorn.survey.data.storage.*
import co.nimblehq.chorn.survey.domain.model.Token
import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import kotlinx.coroutines.flow.*

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val apiCredential: ApiCredential,
    private val encryptedSharedPreferences: EncryptedSharedPreferences
) : AuthRepository {

    override fun login(email: String, password: String): Flow<Unit> = flowTransform {
        val loginRequest = LoginRequest(
            email = email,
            password = password,
            clientId = apiCredential.clientId,
            clientSecret = apiCredential.clientSecret
        )
        val token = authService.login(loginRequest).data?.attributes?.toToken()
        token?.let {
            saveTokens(it)
        } ?: throw Exception("Unable to parse response")
    }

    private fun saveTokens(token: Token) {
        encryptedSharedPreferences.run {
            set(ACCESS_TOKEN_PREFERENCES_KEY, token.accessToken)
            set(REFRESH_TOKEN_PREFERENCES_KEY, token.refreshToken)
            set(TOKEN_TYPE_PREFERENCES_KEY, token.tokenType)
        }
    }
}
