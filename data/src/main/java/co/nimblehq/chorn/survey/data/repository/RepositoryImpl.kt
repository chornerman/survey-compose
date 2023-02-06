package co.nimblehq.chorn.survey.data.repository

import co.nimblehq.chorn.survey.data.extensions.flowTransform
import co.nimblehq.chorn.survey.data.response.toModels
import co.nimblehq.chorn.survey.data.service.ApiService
import co.nimblehq.chorn.survey.domain.model.Model
import co.nimblehq.chorn.survey.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl constructor(
    private val apiService: ApiService
) : Repository {

    override fun getModels(): Flow<List<Model>> = flowTransform {
        apiService.getResponses().toModels()
    }
}
