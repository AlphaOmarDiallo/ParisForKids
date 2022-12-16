package com.alphaomardiallo.parisforkids.common.data.local.dao

import androidx.room.*
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
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

    @Query("SELECT COUNT (*) FROM EventsAndActivities_table")
    fun getEventsCount(): Flow<Int>

    @Query("SELECT EXISTS(SELECT * FROM EventsAndActivities_table WHERE events_and_activities_id = :id)")
    fun isEventExist(id: String): Flow<Boolean>

    @Query("SELECT * FROM EventsAndActivities_table WHERE events_and_activities_id=:id ")
    fun loadSingleEvent(id: String): Flow<Events>

}