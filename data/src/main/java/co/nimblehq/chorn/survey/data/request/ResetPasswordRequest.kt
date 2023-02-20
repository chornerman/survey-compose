package co.nimblehq.chorn.survey.data.request

import com.squareup.moshi.Json

data class ResetPasswordRequest(
    @Json(name = "user")
    val user: User,
    @Json(name = "client_id")
    val clientId: String,
    @Json(name = "client_secret")
    val clientSecret: String
) {
    data class User(
        @Json(name = "email")
        val email: String
    )
}
