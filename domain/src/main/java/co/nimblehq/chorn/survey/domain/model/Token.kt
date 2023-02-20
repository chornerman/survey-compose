package co.nimblehq.chorn.survey.domain.model

data class Token(
    val accessToken: String,
    val refreshToken: String,
    val tokenType: String
)
