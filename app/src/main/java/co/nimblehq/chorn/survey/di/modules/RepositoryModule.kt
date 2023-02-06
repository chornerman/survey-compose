package co.nimblehq.chorn.survey.di.modules

import co.nimblehq.chorn.survey.data.repository.RepositoryImpl
import co.nimblehq.chorn.survey.data.service.ApiService
import co.nimblehq.chorn.survey.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)
}
