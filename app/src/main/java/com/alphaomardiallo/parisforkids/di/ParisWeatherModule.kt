package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.data.remote.RetrofitOpenWeather
import com.alphaomardiallo.parisforkids.data.repository.parisWeather.ParisWeatherRepository
import com.alphaomardiallo.parisforkids.data.repository.parisWeather.ParisWeatherRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ParisWeatherModule {

    @Singleton
    @Provides
    fun provideParisWeatherRepository(retrofitOpenWeather: RetrofitOpenWeather): ParisWeatherRepository =
        ParisWeatherRepositoryImp(retrofitOpenWeather )

}