package com.alphaomardiallo.parisforkids.data.repository.parisWeather

import com.alphaomardiallo.parisforkids.domain.model.weather.ResponseWeather
import retrofit2.Response

interface ParisWeatherRepository {

    suspend fun getParisWeather(): Response<ResponseWeather>
}