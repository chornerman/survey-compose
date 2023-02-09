package co.nimblehq.chorn.survey.data.test

import co.nimblehq.chorn.survey.data.response.BaseErrorResponse
import co.nimblehq.chorn.survey.data.response.ErrorResponse
import io.mockk.every
import io.mockk.mockk
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

object MockUtil {

    val mockHttpException: HttpException
        get() {
            val response = mockk<Response<Any>>()
            val httpException = mockk<HttpException>()
            val responseBody = mockk<ResponseBody>()
            every { response.code() } returns 500
            every { response.message() } returns "message"
            every { response.errorBody() } returns responseBody
            every { httpException.code() } returns response.code()
            every { httpException.message() } returns response.message()
            every { httpException.response() } returns response
            every { responseBody.string() } returns """
{
  "errors": [
    {
      "source": "errorSource",
      "detail": "errorDetail",
      "code": "errorCode"
    }
  ]
}
"""
            return httpException
        }

    val baseErrorResponse = BaseErrorResponse(
        errors = listOf(
            ErrorResponse(detail = "errorDetail")
        )
    )
}
