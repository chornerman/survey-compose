package co.nimblehq.chorn.survey.data.response

import co.nimblehq.chorn.survey.domain.model.Model
import com.squareup.moshi.Json

data class Response(
    @Json(name = "id") val id: Int?
)

private fun Response.toModel() = Model(id = this.id)

fun List<Response>.toModels() = this.map { it.toModel() }
