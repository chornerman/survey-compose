package co.nimblehq.chorn.survey.data.response

import com.squareup.moshi.Json
import co.nimblehq.chorn.survey.domain.model.Error

data class ErrorResponse(
    @Json(name = "errors")
    val errors: List<ErrorDetailResponse>? = null
)

data class ErrorDetailResponse(
    @Json(name = "source")
    val source: String? = null,
    @Json(name = "detail")
    val detail: String? = null,
    @Json(name = "code")
    val code: String? = null
)

internal fun ErrorResponse.toError() = Error(
    message = errors?.first()?.detail.orEmpty()
)
