package com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities

import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow

interface EventsAndActivitiesRepository {

    suspend fun insertEventsAndActivities(events: Events)

    suspend fun updateEventsAndActivities(events: Events)

    suspend fun deleteEventsAndActivities(events: Events)

    fun getEventsAndActivities(): Flow<List<Events>>
}