package com.alphaomardiallo.parisforkids.data.local

import androidx.room.*
import com.alphaomardiallo.parisforkids.data.model.weather.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDAO {

    @Insert
    suspend fun insertWeather(weather: Weather)

    @Update
    suspend fun updateWeather(weather: Weather)

    @Delete
    suspend fun deleteWeather(weather: Weather)

    @Query("SELECT * FROM weather_table")
    fun getWeather(): Flow<List<Weather>>
}