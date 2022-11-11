package com.alphaomardiallo.parisforkids.domain.model.weather

import com.google.gson.annotations.SerializedName

data class ResponseWeather(

    @field:SerializedName("elevation")
    val elevation: Double? = null,

    @field:SerializedName("generationtime_ms")
    val generationtimeMs: Double? = null,

    @field:SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String? = null,

    @field:SerializedName("daily_units")
    val dailyUnits: DailyUnits? = null,

    @field:SerializedName("timezone")
    val timezone: String? = null,

    @field:SerializedName("latitude")
    val latitude: Double? = null,

    @field:SerializedName("daily")
    val daily: Daily? = null,

    @field:SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int? = null,

    @field:SerializedName("current_weather")
    val currentWeather: CurrentWeather? = null,

    @field:SerializedName("longitude")
    val longitude: Double? = null
)

data class DailyUnits(

    @field:SerializedName("weathercode")
    val weathercode: String? = null,

    @field:SerializedName("temperature_2m_max")
    val temperature2mMax: String? = null,

    @field:SerializedName("temperature_2m_min")
    val temperature2mMin: String? = null,

    @field:SerializedName("time")
    val time: String? = null
)

data class Daily(

    @field:SerializedName("weathercode")
    val weathercode: List<Double?>? = null,

    @field:SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double?>? = null,

    @field:SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double?>? = null,

    @field:SerializedName("time")
    val time: List<String?>? = null
)

data class CurrentWeather(

    @field:SerializedName("weathercode")
    val weathercode: Double? = null,

    @field:SerializedName("temperature")
    val temperature: Double? = null,

    @field:SerializedName("windspeed")
    val windspeed: Double? = null,

    @field:SerializedName("time")
    val time: String? = null,

    @field:SerializedName("winddirection")
    val winddirection: Double? = null
)
