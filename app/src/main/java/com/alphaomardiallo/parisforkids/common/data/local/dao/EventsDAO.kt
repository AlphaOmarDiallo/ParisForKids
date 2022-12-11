package com.alphaomardiallo.parisforkids.common.data.local.dao

import androidx.room.*
import com.alphaomardiallo.parisforkids.common.data.local.pagingSource.EventsPagingSource
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events

@Dao
interface EventsDAO {

    @Insert
    suspend fun insertEvents(events: Events)

    @Update
    suspend fun updateEvents(events: Events)

    @Delete
    suspend fun deleteEventsAndActivities(events: Events)

    @Query("SELECT COUNT(*) FROM EventsAndActivities_table")
    fun getEventsCount(): Int

    @Query("SELECT * FROM EventsAndActivities_table")
    fun getEvents(): EventsPagingSource
}