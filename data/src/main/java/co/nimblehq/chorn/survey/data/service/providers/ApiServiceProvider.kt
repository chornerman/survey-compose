package co.nimblehq.chorn.survey.data.service.providers

import co.nimblehq.chorn.survey.data.service.AuthService
import retrofit2.Retrofit

object ApiServiceProvider {

    fun getAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}
