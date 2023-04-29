package com.alphaomardiallo.parisforkids.common.data.local.converters

import androidx.room.TypeConverter
import com.alphaomardiallo.parisforkids.common.domain.model.weather.ResponseWeather
import com.google.gson.Gson

class ConverterWeather {
    @TypeConverter
    fun weatherFromString(value: String?): ResponseWeather? {
        return Gson().fromJson(value, ResponseWeather::class.java)
    }

    @TypeConverter
    fun stringToWeather(responseWeather: ResponseWeather): String? {
        return Gson().toJson(responseWeather)
    }
}
