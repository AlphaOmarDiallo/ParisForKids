package com.alphaomardiallo.parisforkids.data.local

import androidx.room.*
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsAndActivitiesDAO {

    @Insert
    suspend fun insertEventsAndActivities(events: Events)

    @Update
    suspend fun updateEventsAndActivities(events: Events)

    @Delete
    suspend fun deleteEventsAndActivities(events: Events)

    @Query("SELECT * FROM EventsAndActivities_table")
    fun getEventsAndActivities(): Flow<List<Events>>
}