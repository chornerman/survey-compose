package co.nimblehq.chorn.survey.data.response

import com.squareup.moshi.Json

data class BaseResponse<T>(
    @Json(name = "data")
    val data: DataResponse<T>? = null,
)

data class DataResponse<T>(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "attributes")
    val attributes: T? = null
)
