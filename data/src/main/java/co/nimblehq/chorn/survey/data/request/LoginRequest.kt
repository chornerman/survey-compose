package co.nimblehq.chorn.survey.data.request

import com.squareup.moshi.Json

const val GRANT_TYPE_PASSWORD = "password"

data class LoginRequest(
    @Json(name = "grant_type")
    val grantType: String = GRANT_TYPE_PASSWORD,
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "client_id")
    val clientId: String,
    @Json(name = "client_secret")
    val clientSecret: String
)
