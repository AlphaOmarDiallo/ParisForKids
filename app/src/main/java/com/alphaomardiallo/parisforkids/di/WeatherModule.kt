package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.common.data.local.dao.WeatherDAO
import com.alphaomardiallo.parisforkids.common.data.repository.weather.WeatherRepository
import com.alphaomardiallo.parisforkids.common.data.repository.weather.WeatherRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherDAO: WeatherDAO): WeatherRepository =
        WeatherRepositoryImp(weatherDAO)
}