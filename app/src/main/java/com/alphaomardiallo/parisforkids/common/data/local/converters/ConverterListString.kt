package com.alphaomardiallo.parisforkids.common.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterListString {
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        val listType = object :
            TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String?>?): String? {
        return Gson().toJson(list)
    }
}
