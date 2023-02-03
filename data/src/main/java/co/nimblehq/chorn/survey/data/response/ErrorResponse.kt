package co.nimblehq.chorn.survey.data.response

import co.nimblehq.chorn.survey.domain.model.Error
import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "message")
    val message: String
)

internal fun ErrorResponse.toModel() = Error(message = message)
