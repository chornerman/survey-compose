package co.nimblehq.chorn.survey.ui.screens.login

import app.cash.turbine.test
import co.nimblehq.chorn.survey.domain.usecase.LoginUseCase
import co.nimblehq.chorn.survey.test.CoroutineTestRule
import co.nimblehq.chorn.survey.ui.AppDestination
import co.nimblehq.chorn.survey.util.DispatchersProvider
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.*

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val coroutinesRule = CoroutineTestRule()

    private val mockLoginUseCase: LoginUseCase = mockk()
    private val email = "e@mail.com"
    private val password = "password"

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        every { mockLoginUseCase(any()) } returns flowOf(Unit)

        initViewModel()
    }

    @Test
    fun `When calling login with Success result, it navigates to Home screen3`() = runTest {
        viewModel.navigator.test {
            viewModel.login(email, password)

            expectMostRecentItem() shouldBe AppDestination.Home
        }
    }

    @Test
    fun `When calling login with Success result, it navigates to Home screen`() = runTest {
        viewModel.invalidInputError.test {
            viewModel.login("email", "")

            expectMostRecentItem() shouldBe Unit
        }
    }

    @Test
    fun `When calling login with Success result, it navigates to Home screen2`() = runTest {
        val error = Exception()
        every { mockLoginUseCase(any()) } returns flow { throw error }

        viewModel.error.test {
            viewModel.login(email, password)

            expectMostRecentItem() shouldBe error
        }
    }

    @Test
    fun `When calling login with Success result, it navigates to Home screen4`() = runTest {
        initViewModel(dispatchers = CoroutineTestRule(StandardTestDispatcher()).testDispatcherProvider)

        viewModel.login(email, password)

        viewModel.isLoading.test {
            awaitItem() shouldBe false
            awaitItem() shouldBe true
            awaitItem() shouldBe false
        }
    }

    private fun initViewModel(dispatchers: DispatchersProvider = coroutinesRule.testDispatcherProvider) {
        viewModel = LoginViewModel(
            mockLoginUseCase,
            dispatchers
        )
    }
}
