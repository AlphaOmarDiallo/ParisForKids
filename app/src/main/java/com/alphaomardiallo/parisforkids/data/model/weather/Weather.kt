package com.alphaomardiallo.parisforkids.data.model.weather

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class Weather(
    @PrimaryKey
    @ColumnInfo(name = "weather_id")
    val id: Long,
    @ColumnInfo(name = "weather_data")
    var data: ResponseWeather,
    @ColumnInfo(name = "weather_date")
    var date: String
)
