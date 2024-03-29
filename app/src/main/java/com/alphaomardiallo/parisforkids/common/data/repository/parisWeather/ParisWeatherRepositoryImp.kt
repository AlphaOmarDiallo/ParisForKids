package com.alphaomardiallo.parisforkids.common.data.repository.parisWeather

import com.alphaomardiallo.parisforkids.common.data.remote.RetrofitOpenWeather
import com.alphaomardiallo.parisforkids.common.domain.model.weather.ResponseWeather
import retrofit2.Response
import javax.inject.Inject

class ParisWeatherRepositoryImp @Inject constructor(
    private val retrofitOpenWeather: RetrofitOpenWeather
) : ParisWeatherRepository {

    private val parisLat = 48.8567
    private val parisLong = 2.3510
    private val daily = "weathercode"
    private val daily2 = "temperature_2m_max"
    private val daily3 = "temperature_2m_min"
    private val currentWeather = true
    private val timezone = "auto"

    override suspend fun getParisWeather(): Response<ResponseWeather> {
        return retrofitOpenWeather.getParisWeather(
            parisLat,
            parisLong,
            daily,
            daily2,
            daily3,
            currentWeather,
            timezone
        )
    }
}
