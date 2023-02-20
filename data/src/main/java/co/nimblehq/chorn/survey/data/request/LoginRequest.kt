package co.nimblehq.chorn.survey.data.request

import com.squareup.moshi.Json

const val PASSWORD_GRANT_TYPE = "password"

data class LoginRequest(
    @Json(name = "grant_type")
    val grantType: String = PASSWORD_GRANT_TYPE,
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "client_id")
    val clientId: String,
    @Json(name = "client_secret")
    val clientSecret: String
)
