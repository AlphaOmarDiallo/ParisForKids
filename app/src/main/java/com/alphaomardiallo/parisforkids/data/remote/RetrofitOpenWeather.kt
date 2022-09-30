package com.alphaomardiallo.parisforkids.data.remote

import com.alphaomardiallo.parisforkids.data.model.weather.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitOpenWeather {
    @GET("v1/forecast?")
    suspend fun getParisWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("timezone") timezone: String
    ): Response<Weather>
}