package com.alphaomardiallo.parisforkids.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.EventsAndActivities

@Database(entities = [EventsAndActivities::class], version = 1, exportSchema = true)
abstract class LocalDatabase: RoomDatabase() {

abstract fun eventsAndActivitiesDAO(): EventsAndActivitiesDAO

}