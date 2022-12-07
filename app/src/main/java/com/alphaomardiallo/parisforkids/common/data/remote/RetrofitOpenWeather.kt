package com.alphaomardiallo.parisforkids.common.data.remote

import com.alphaomardiallo.parisforkids.common.domain.model.weather.ResponseWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitOpenWeather {
    @GET("v1/forecast?")
    suspend fun getParisWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("daily") daily1: String,
        @Query("daily") daily2: String,
        @Query("current_weather") currentWeather: Boolean,
        @Query("timezone") timezone: String
    ): Response<ResponseWeather>
}