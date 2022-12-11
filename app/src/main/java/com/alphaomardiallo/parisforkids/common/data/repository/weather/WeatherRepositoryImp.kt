package com.alphaomardiallo.parisforkids.common.data.repository.weather

import com.alphaomardiallo.parisforkids.common.data.local.dao.WeatherDAO
import com.alphaomardiallo.parisforkids.common.domain.model.weather.Weather
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val weatherDAO: WeatherDAO
) : WeatherRepository {
    override suspend fun insertWeather(weather: Weather) {
        weatherDAO.insertWeather(weather)
    }

    override suspend fun updateWeather(weather: Weather) {
        weatherDAO.updateWeather(weather)
    }

    override suspend fun deleteWeather(weather: Weather) {
        weatherDAO.deleteWeather(weather)
    }

    override fun getWeather(): Flow<List<Weather>> {
        return weatherDAO.getWeather()
    }

}