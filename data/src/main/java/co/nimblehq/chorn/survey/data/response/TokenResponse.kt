package co.nimblehq.chorn.survey.data.response

import co.nimblehq.chorn.survey.domain.model.Token
import com.squareup.moshi.Json

data class TokenResponse(
    @Json(name = "access_token")
    val accessToken: String?,
    @Json(name = "token_type")
    val tokenType: String?,
    @Json(name = "expires_in")
    val expiresIn: Long?,
    @Json(name = "refresh_token")
    val refreshToken: String?,
    @Json(name = "created_at")
    val createdAt: Long?
)

fun TokenResponse.toToken() = Token(
    accessToken = accessToken.orEmpty(),
    refreshToken = refreshToken.orEmpty(),
    tokenType = tokenType.orEmpty()
)
