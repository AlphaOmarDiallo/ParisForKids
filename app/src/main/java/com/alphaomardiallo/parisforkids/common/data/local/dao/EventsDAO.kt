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

    // TODO: test all the new methods
    /**
     * Fetch all the events available on the day
     */
    @Query("SELECT * FROM EventsAndActivities_table WHERE strftime('%Y-%m-%d', events_and_response_date_start) = date('now')")
    fun getEventsToday(): Flow<List<Event>>

    /**
     * Fetch all the events by theme
     */
    @Query("SELECT * FROM EventsAndActivities_table WHERE events_and_response_tags LIKE '%' || :theme || '%'")
    fun getEventsByTheme(theme: String): Flow<List<Event>>

    /**
     * Select all the events of the current week
     */
    @Query("SELECT * FROM EventsAndActivities_table WHERE strftime('%W', events_and_response_date_start) = strftime('%W', 'now')")
    fun getEventsOfTheWeek(): Flow<List<Event>>
}
