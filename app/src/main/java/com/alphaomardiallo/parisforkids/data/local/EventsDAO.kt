package com.alphaomardiallo.parisforkids.data.local

import androidx.room.*
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDAO {

    @Insert
    suspend fun insertEvents(events: Events)

    @Update
    suspend fun updateEvents(events: Events)

    @Delete
    suspend fun deleteEventsAndActivities(events: Events)

    @Query("SELECT * FROM EventsAndActivities_table")
    fun getEvents(): Flow<List<Events>>
}