package co.nimblehq.chorn.survey.di.modules

import co.nimblehq.chorn.survey.BuildConfig
import co.nimblehq.chorn.survey.data.service.AuthService
import co.nimblehq.chorn.survey.data.service.ApiCredential
import co.nimblehq.chorn.survey.data.storage.EncryptedSharedPreferences
import co.nimblehq.chorn.survey.data.repository.AuthRepositoryImpl
import co.nimblehq.chorn.survey.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideApiCredential() = ApiCredential(
        clientId = BuildConfig.CLIENT_ID,
        clientSecret = BuildConfig.CLIENT_SECRET
    )

    @Provides
    fun provideAuthRepository(
        authService: AuthService,
        apiCredential: ApiCredential,
        encryptedSharedPreferences: EncryptedSharedPreferences
    ): AuthRepository =
        AuthRepositoryImpl(authService, apiCredential, encryptedSharedPreferences)
}
