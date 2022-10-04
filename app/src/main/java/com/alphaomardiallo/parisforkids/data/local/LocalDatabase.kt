package com.alphaomardiallo.parisforkids.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alphaomardiallo.parisforkids.data.local.converters.ConverterEvents
import com.alphaomardiallo.parisforkids.data.local.converters.ConverterListString
import com.alphaomardiallo.parisforkids.data.local.converters.ConverterWeather
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import com.alphaomardiallo.parisforkids.data.model.weather.Weather

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