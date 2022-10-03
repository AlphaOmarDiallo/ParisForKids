package com.alphaomardiallo.parisforkids.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alphaomardiallo.parisforkids.data.local.converters.ConverterEventsAndActivities
import com.alphaomardiallo.parisforkids.data.local.converters.ConverterListString
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events

@Database(entities = [Events::class], version = 1, exportSchema = true)
@TypeConverters(ConverterListString::class, ConverterEventsAndActivities::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun eventsAndActivitiesDAO(): EventsAndActivitiesDAO

}