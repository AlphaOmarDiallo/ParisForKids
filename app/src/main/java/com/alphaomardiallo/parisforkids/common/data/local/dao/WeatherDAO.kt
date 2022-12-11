package com.alphaomardiallo.parisforkids.common.data.local.dao

import androidx.room.*
import com.alphaomardiallo.parisforkids.common.domain.model.weather.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: Weather)

    @Update
    suspend fun updateWeather(weather: Weather)

    @Delete
    suspend fun deleteWeather(weather: Weather)

    @Query("SELECT * FROM weather_table")
    fun getWeather(): Flow<List<Weather>>
}