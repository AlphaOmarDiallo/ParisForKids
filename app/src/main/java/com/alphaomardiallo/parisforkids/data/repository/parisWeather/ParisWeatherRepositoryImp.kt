package com.alphaomardiallo.parisforkids.data.repository.parisWeather

import com.alphaomardiallo.parisforkids.data.model.weather.Weather
import com.alphaomardiallo.parisforkids.data.remote.RetrofitOpenWeather
import retrofit2.Response
import javax.inject.Inject

class ParisWeatherRepositoryImp @Inject constructor(
    private val retrofitOpenWeather: RetrofitOpenWeather
): ParisWeatherRepository {
    override suspend fun getParisWeather(): Response<Weather> {
        TODO("Not yet implemented")
    }
}