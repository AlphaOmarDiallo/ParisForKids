package com.alphaomardiallo.parisforkids.data.repository.weather

import com.alphaomardiallo.parisforkids.data.model.weather.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun insertWeather(weather: Weather)

    suspend fun updateWeather(weather: Weather)

    suspend fun deleteWeather(weather: Weather)

    fun getWeather(): Flow<List<Weather>>
}