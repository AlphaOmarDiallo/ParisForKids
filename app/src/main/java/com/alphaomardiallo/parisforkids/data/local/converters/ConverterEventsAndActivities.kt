package com.alphaomardiallo.parisforkids.data.local.converters

import androidx.room.TypeConverter
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.ResponseQueFaireAParis
import com.google.gson.Gson

class ConverterEventsAndActivities {
    @TypeConverter
    fun eventsAndActivitiesFromString(value: String?): ResponseQueFaireAParis? {
        return Gson().fromJson(value, ResponseQueFaireAParis::class.java)
    }

    @TypeConverter
    fun placeListFromListToString(responseQueFaireAParis: ResponseQueFaireAParis): String? {
        val gson = Gson()
        return gson.toJson(responseQueFaireAParis)
    }
}