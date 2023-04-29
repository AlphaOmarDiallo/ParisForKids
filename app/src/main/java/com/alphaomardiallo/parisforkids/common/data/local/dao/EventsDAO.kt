package com.alphaomardiallo.parisforkids.common.data.local.dao

import androidx.room.*
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDAO {

    @Insert
    suspend fun insertEvents(events: Event)

    @Update
    suspend fun updateEvents(events: Event)

    @Delete
    suspend fun deleteEventsAndActivities(events: Event)

    /**
     * Get the list of all the events present in the database
     */
    @Query("SELECT * FROM EventsAndActivities_table")
    fun getEvents(): Flow<List<Event>>

    /**
     * Get the number of events present in the database
     */
    @Query("SELECT COUNT (*) FROM EventsAndActivities_table")
    fun getEventsCount(): Flow<Int>

    /**
     * Check if events is already present in the database
     */
    @Query("SELECT EXISTS(SELECT * FROM EventsAndActivities_table WHERE events_and_activities_id = :id)")
    fun isEventExist(id: String): Flow<Boolean>

    /**
     *  Fetch one event using the id of the event.
     */
    @Query("SELECT * FROM EventsAndActivities_table WHERE events_and_activities_id=:id ")
    fun loadSingleEvent(id: String): Flow<Event>

    /**
     * Fetch the list of distinct theme in the database et provides a list of it, simplifies ordering
     */
    @Query("SELECT DISTINCT events_and_response_tags FROM EventsAndActivities_table")
    fun selectDistinctTags(): Flow<List<String>>

}