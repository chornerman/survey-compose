package co.nimblehq.chorn.survey.data.repository

import co.nimblehq.chorn.survey.data.extensions.flowTransform
import co.nimblehq.chorn.survey.data.request.LoginRequest
import co.nimblehq.chorn.survey.data.response.toToken
import co.nimblehq.chorn.survey.data.service.AuthService
import co.nimblehq.chorn.survey.data.service.ApiCredential
import co.nimblehq.chorn.survey.data.storage.EncryptedSharedPreferences
import co.nimblehq.chorn.survey.data.storage.SharedPreferenceKeys
import co.nimblehq.chorn.survey.domain.model.Token
import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import kotlinx.coroutines.flow.*

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val apiCredential: ApiCredential,
    private val sharedPreferences: EncryptedSharedPreferences
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
        sharedPreferences.run {
            set(SharedPreferenceKeys.ACCESS_TOKEN, token.accessToken)
            set(SharedPreferenceKeys.REFRESH_TOKEN, token.refreshToken)
            set(SharedPreferenceKeys.TOKEN_TYPE, token.tokenType)
        }
    }
}
