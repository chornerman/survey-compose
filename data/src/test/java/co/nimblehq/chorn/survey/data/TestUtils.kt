package co.nimblehq.chorn.survey.data

import co.nimblehq.chorn.survey.data.response.*

fun <T : Any> T.toBaseResponse() = BaseResponse(
    data = DataResponse(
        id = "id",
        type = "type",
        attributes = this
    ),
)
