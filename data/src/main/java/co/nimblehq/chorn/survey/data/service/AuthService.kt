package co.nimblehq.chorn.survey.data.service

import co.nimblehq.chorn.survey.data.request.LoginRequest
import co.nimblehq.chorn.survey.data.response.BaseResponse
import co.nimblehq.chorn.survey.data.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/v1/oauth/token")
    suspend fun login(@Body loginRequest: LoginRequest): BaseResponse<TokenResponse>
}
