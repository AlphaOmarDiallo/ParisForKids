package com.alphaomardiallo.parisforkids.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.EventsAndActivities

@Dao
interface EventsAndActivitiesDAO {

    @Insert
    suspend fun insertEventsAndActivities(eventsAndActivities: EventsAndActivities)

    @Update
    suspend fun updateEventsAndActivities(eventsAndActivities: EventsAndActivities)

    @Delete
    suspend fun deleteEventsAndActivities(eventsAndActivities: EventsAndActivities)
}