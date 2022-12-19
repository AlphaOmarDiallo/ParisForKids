package com.alphaomardiallo.parisforkids.common.data.local.converters

import androidx.room.TypeConverter
import com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis.Record
import com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis.ResponseQueFaireAParis
import com.google.gson.Gson

class ConverterEvents {
    @TypeConverter
    fun eventsResponseFromString(value: String?): ResponseQueFaireAParis? {
        return Gson().fromJson(value, ResponseQueFaireAParis::class.java)
    }

    @TypeConverter
    fun stringFromEventsResponse(responseQueFaireAParis: ResponseQueFaireAParis): String? {
        val gson = Gson()
        return gson.toJson(responseQueFaireAParis)
    }

    @TypeConverter
    fun eventsItemFromString(value: String?): Record? {
        return Gson().fromJson(value, Record::class.java)
    }

    @TypeConverter
    fun stringFromEventsItem(record: Record): String? {
        val gson = Gson()
        return gson.toJson(record)
    }
}