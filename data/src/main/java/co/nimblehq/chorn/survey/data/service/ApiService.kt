package co.nimblehq.chorn.survey.data.service

import co.nimblehq.chorn.survey.data.response.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getResponses(): List<Response>
}
