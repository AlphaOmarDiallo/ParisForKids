package com.alphaomardiallo.parisforkids.common.data.repository.parisWeather

import com.alphaomardiallo.parisforkids.common.domain.model.weather.ResponseWeather
import retrofit2.Response

interface ParisWeatherRepository {

    suspend fun getParisWeather(): Response<ResponseWeather>
}
