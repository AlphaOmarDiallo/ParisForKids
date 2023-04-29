package com.alphaomardiallo.parisforkids.common.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterListDouble {
    @TypeConverter
    fun fromString(value: String?): List<Double>? {
        val listType = object :
            TypeToken<ArrayList<Double?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Double?>?): String? {
        return Gson().toJson(list)
    }
}
