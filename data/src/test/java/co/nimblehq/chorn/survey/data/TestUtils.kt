package co.nimblehq.chorn.survey.data

import co.nimblehq.chorn.survey.data.response.*

fun <T : Any> T.toResponse() = Response(
    data = DataResponse(
        id = "id",
        type = "type",
        attributes = this
    ),
)
