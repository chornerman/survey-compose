package co.nimblehq.chorn.survey.domain.usecase

import co.nimblehq.chorn.survey.domain.model.Model
import co.nimblehq.chorn.survey.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<List<Model>> {
        return repository.getModels()
    }
}
