package co.nimblehq.chorn.survey.data.extensions

import co.nimblehq.chorn.survey.data.response.toModel
import co.nimblehq.chorn.survey.data.test.MockUtil
import co.nimblehq.chorn.survey.domain.exceptions.ApiException
import co.nimblehq.chorn.survey.domain.exceptions.NoConnectivityException
import co.nimblehq.chorn.survey.domain.model.Model
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.IOException
import java.io.InterruptedIOException
import java.net.UnknownHostException

@ExperimentalCoroutinesApi
class ResponseMappingTest {

    @Test
    fun `When mapping API request flow failed with UnknownHostException, it returns mapped NoConnectivityException error`() =
        runTest {
            flowTransform<Model> {
                throw UnknownHostException()
            }.catch {
                it shouldBe NoConnectivityException
            }.collect()
        }

    @Test
    fun `When mapping API request flow failed with InterruptedIOException, it returns mapped NoConnectivityException error`() =
        runTest {
            flowTransform<Model> {
                throw InterruptedIOException()
            }.catch {
                it shouldBe NoConnectivityException
            }.collect()
        }

    @Test
    fun `When mapping API request flow failed with HttpException, it returns mapped ApiException error`() =
        runTest {
            val httpException = MockUtil.mockHttpException
            flowTransform<Model> {
                throw httpException
            }.catch {
                it shouldBe ApiException(
                    MockUtil.errorResponse.toModel(),
                    httpException.code(),
                    httpException.message()
                )
            }.collect()
        }

    @Test
    fun `When mapping API request flow failed with unhandled exceptions, it should throw that error`() =
        runTest {
            val exception = IOException("Canceled")
            flowTransform<Model> {
                throw exception
            }.catch {
                it shouldBe exception
            }.collect()
        }
}