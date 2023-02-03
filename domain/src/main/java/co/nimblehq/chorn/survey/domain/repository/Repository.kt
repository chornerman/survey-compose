package co.nimblehq.chorn.survey.domain.repository

import co.nimblehq.chorn.survey.domain.model.Model
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getModels(): Flow<List<Model>>
}
