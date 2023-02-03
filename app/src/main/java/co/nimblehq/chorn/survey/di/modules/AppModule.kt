package co.nimblehq.chorn.survey.di.modules

import co.nimblehq.chorn.survey.util.DispatchersProvider
import co.nimblehq.chorn.survey.util.DispatchersProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideDispatchersProvider(): DispatchersProvider {
        return DispatchersProviderImpl()
    }
}
