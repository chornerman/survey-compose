package co.nimblehq.template.compose.di.modules

import co.nimblehq.template.compose.data.service.providers.MoshiBuilderProvider
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MoshiModule {

    @Provides
    fun provideMoshi(): Moshi = MoshiBuilderProvider.moshiBuilder.build()
}
