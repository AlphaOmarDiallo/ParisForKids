package com.alphaomardiallo.parisforkids.common.data.local.converters

import androidx.room.TypeConverter
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.RecordsItem
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.ResponseQueFaireAParis
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
    fun eventsItemFromString(value: String?): RecordsItem? {
        return Gson().fromJson(value, RecordsItem::class.java)
    }

    @TypeConverter
    fun stringFromEventsItem(recordsItem: RecordsItem): String? {
        val gson = Gson()
        return gson.toJson(recordsItem)
    }
}