package co.nimblehq.chorn.survey.data.service

import co.nimblehq.chorn.survey.data.request.LoginRequest
import co.nimblehq.chorn.survey.data.request.ResetPasswordRequest
import co.nimblehq.chorn.survey.data.response.Response
import co.nimblehq.chorn.survey.data.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/v1/oauth/token")
    suspend fun login(@Body loginRequest: LoginRequest): Response<TokenResponse>

    @POST("/api/v1/passwords")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest)
}
