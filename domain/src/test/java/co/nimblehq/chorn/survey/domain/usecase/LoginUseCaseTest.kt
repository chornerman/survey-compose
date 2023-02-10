package co.nimblehq.chorn.survey.domain.usecase

import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import co.nimblehq.chorn.survey.domain.usecase.LoginUseCase.*
import io.kotest.matchers.shouldBe
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginUseCaseTest {

    private val mockAuthRepository: AuthRepository = mockk()
    private val loginInput = LoginInput("email", "password")

    private lateinit var useCase: LoginUseCase

    @Before
    fun setUp() {
        useCase = LoginUseCase(mockAuthRepository)
    }

    @Test
    fun `When executing use case and repository returns success, it emits Unit`() = runTest {
        every { mockAuthRepository.login(any(), any()) } returns flowOf(Unit)

        useCase(loginInput).collect { it shouldBe Unit }
    }

    @Test
    fun `When executing use case and repository returns error, it throws the corresponding error`() =
        runTest {
            val expected = Exception()
            every { mockAuthRepository.login(any(), any()) } returns flow { throw expected }

            useCase(loginInput).catch { it shouldBe expected }.collect()
        }
}
