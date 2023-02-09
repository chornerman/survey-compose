package co.nimblehq.chorn.survey.data.repository

import co.nimblehq.chorn.survey.data.response.TokenResponse
import co.nimblehq.chorn.survey.data.service.AuthService
import co.nimblehq.chorn.survey.data.service.ApiCredential
import co.nimblehq.chorn.survey.data.storage.EncryptedSharedPreferences
import co.nimblehq.chorn.survey.data.storage.SharedPreferenceKeys
import co.nimblehq.chorn.survey.data.toBaseResponse
import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import io.kotest.matchers.shouldBe
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AuthRepositoryTest {

    private lateinit var mockAuthService: AuthService
    private lateinit var mockSharedPreferences: EncryptedSharedPreferences
    private lateinit var apiCredential: ApiCredential
    private lateinit var repository: AuthRepository

    private val email = "email"
    private val password = "password"

    @Before
    fun setUp() {
        mockAuthService = mockk()
        mockSharedPreferences = mockk()
        apiCredential = ApiCredential(
            clientId = "clientId",
            clientSecret = "clientSecret"
        )
        repository = AuthRepositoryImpl(mockAuthService, apiCredential, mockSharedPreferences)

        every { mockSharedPreferences.set<Any>(any(), any()) } returns Unit
    }

    @Test
    fun `When calling login successfully, it emits Unit`() = runTest {
        val tokenResponse = TokenResponse(
            accessToken = "accessToken",
            tokenType = "tokenType",
            expiresIn = 0,
            refreshToken = "refreshToken",
            createdAt = 0
        )
        coEvery { mockAuthService.login(any()) } returns tokenResponse.toBaseResponse()

        repository.login(email, password).collect {
            it shouldBe Unit
        }
        coVerify(exactly = 1) {
            mockSharedPreferences.run {
                set(SharedPreferenceKeys.ACCESS_TOKEN, tokenResponse.accessToken)
                set(SharedPreferenceKeys.REFRESH_TOKEN, tokenResponse.refreshToken)
                set(SharedPreferenceKeys.TOKEN_TYPE, tokenResponse.tokenType)
            }
        }
    }

    @Test
    fun `When calling login failed, it throws the corresponding error`() = runTest {
        val expected = Throwable()
        coEvery { mockAuthService.login(any()) } throws expected

        repository.login(email, password).catch {
            it shouldBe expected
        }.collect()
    }
}
