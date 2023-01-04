package com.eahm.thecalorietracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.eahm.core.data.preferences.DefaultPreferences
import com.eahm.core.domain.preferences.Preferences
import com.eahm.core.domain.usecase.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application,
    ): SharedPreferences {
        return app.getSharedPreferences(
            /* name = */
            "shared_pref",
            /* mode = */
            MODE_PRIVATE,
        )
    }

    @Provides
    @Singleton
    fun providePreferences(
        sharedPreferences: SharedPreferences,
    ): Preferences {
        return DefaultPreferences(
            sharedPref = sharedPreferences,
        )
    }

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }
}