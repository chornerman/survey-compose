package co.nimblehq.chorn.survey.domain.usecase

import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ResetPasswordUseCaseTest {

    private val mockAuthRepository: AuthRepository = mockk()
    private val email = "email"

    private lateinit var useCase: ResetPasswordUseCase

    @Before
    fun setUp() {
        useCase = ResetPasswordUseCase(mockAuthRepository)
    }

    @Test
    fun `When executing use case and repository returns success, it emits Unit`() = runTest {
        every { mockAuthRepository.resetPassword(any()) } returns flowOf(Unit)

        useCase(email).collect { it shouldBe Unit }
    }

    @Test
    fun `When executing use case and repository returns error, it throws the corresponding error`() =
        runTest {
            val expected = Exception()
            every { mockAuthRepository.resetPassword(any()) } returns flow { throw expected }

            useCase(email).catch { it shouldBe expected }.collect()
        }
}
