package com.alphaomardiallo.parisforkids.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alphaomardiallo.parisforkids.common.data.local.converters.ConverterEvents
import com.alphaomardiallo.parisforkids.common.data.local.converters.ConverterListString
import com.alphaomardiallo.parisforkids.common.data.local.converters.ConverterWeather
import com.alphaomardiallo.parisforkids.common.data.local.dao.EventsDAO
import com.alphaomardiallo.parisforkids.common.data.local.dao.WeatherDAO
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import com.alphaomardiallo.parisforkids.common.domain.model.weather.Weather

@Database(entities = [Events::class, Weather::class], version = 1, exportSchema = true)
@TypeConverters(
    ConverterListString::class,
    ConverterEvents::class,
    ConverterWeather::class
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun eventsAndActivitiesDAO(): EventsDAO

    abstract fun weatherDao(): WeatherDAO

}