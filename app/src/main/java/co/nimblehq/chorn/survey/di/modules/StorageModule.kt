package co.nimblehq.chorn.survey.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import co.nimblehq.chorn.survey.data.storage.EncryptedSharedPreferences
import co.nimblehq.chorn.survey.data.storage.NormalSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    companion object {

        @Provides
        fun provideDefaultSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        @Provides
        fun provideSecuredLocalStorage(@ApplicationContext context: Context) =
            EncryptedSharedPreferences(context)

        @Provides
        fun provideNormalLocalStorage(
            @ApplicationContext context: Context,
            defaultSharedPreferences: SharedPreferences
        ) = NormalSharedPreferences(context, defaultSharedPreferences)
    }
}
