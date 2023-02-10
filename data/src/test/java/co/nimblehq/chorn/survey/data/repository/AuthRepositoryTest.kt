package co.nimblehq.chorn.survey.data.repository

import co.nimblehq.chorn.survey.data.response.TokenResponse
import co.nimblehq.chorn.survey.data.service.AuthService
import co.nimblehq.chorn.survey.data.service.ApiCredential
import co.nimblehq.chorn.survey.data.storage.*
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

    private val mockAuthService: AuthService = mockk()
    private val mockSharedPreferences: EncryptedSharedPreferences = mockk()
    private val apiCredential: ApiCredential = ApiCredential(
        clientId = "clientId",
        clientSecret = "clientSecret"
    )
    private lateinit var repository: AuthRepository

    private val email = "email"
    private val password = "password"

    @Before
    fun setUp() {
        repository = AuthRepositoryImpl(
            authService = mockAuthService,
            apiCredential = apiCredential,
            sharedPreferences = mockSharedPreferences
        )

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
                set(ACCESS_TOKEN_PREFERENCES_KEY, tokenResponse.accessToken)
                set(REFRESH_TOKEN_PREFERENCES_KEY, tokenResponse.refreshToken)
                set(TOKEN_TYPE_PREFERENCES_KEY, tokenResponse.tokenType)
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
