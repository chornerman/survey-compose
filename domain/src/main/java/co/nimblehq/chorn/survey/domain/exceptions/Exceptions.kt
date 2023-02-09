package co.nimblehq.chorn.survey.domain.exceptions

import co.nimblehq.chorn.survey.domain.model.Error

object NoConnectivityException : RuntimeException()

data class ApiException(
    val error: Error?,
    val httpCode: Int
) : RuntimeException()
