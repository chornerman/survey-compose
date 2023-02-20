package co.nimblehq.chorn.survey.data.test

import co.nimblehq.chorn.survey.data.response.*
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
            every { responseBody.string() } returns "{\n" +
                "  \"errors\": [\n" +
                "    {\n" +
                "      \"source\": \"errorSource\",\n" +
                "      \"detail\": \"errorDetail\",\n" +
                "      \"code\": \"errorCode\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
            return httpException
        }

    val errorResponse = ErrorResponse(
        errors = listOf(
            ErrorDetailResponse(detail = "errorDetail")
        )
    )
}
