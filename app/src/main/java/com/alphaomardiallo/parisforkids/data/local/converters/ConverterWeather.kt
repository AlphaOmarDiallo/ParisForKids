package com.alphaomardiallo.parisforkids.data.local.converters

import androidx.room.TypeConverter
import com.alphaomardiallo.parisforkids.data.model.weather.ResponseWeather
import com.google.gson.Gson

class ConverterWeather {
    @TypeConverter
    fun weatherFromString(value: String?): ResponseWeather? {
        return Gson().fromJson(value, ResponseWeather::class.java)
    }

    @TypeConverter
    fun stringToWeather(responseWeather: ResponseWeather): String? {
        val gson = Gson()
        return gson.toJson(responseWeather)
    }
}