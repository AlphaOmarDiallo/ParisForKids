package com.alphaomardiallo.parisforkids.di

import android.content.Context
import androidx.room.Room
import com.alphaomardiallo.parisforkids.data.local.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(
            app,
            LocalDatabase::class.java,
            "LocalDatabase"
        )
            .build()

    @Singleton
    @Provides
    fun provideEventsAndActivitiesDao(database: LocalDatabase) = database.eventsAndActivitiesDAO()

    @Singleton
    @Provides
    fun provideWeatherDao(database: LocalDatabase) = database.weatherDao()
}