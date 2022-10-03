package com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities

import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.EventsAndActivities
import kotlinx.coroutines.flow.Flow

interface EventsAndActivitiesRepository {

    suspend fun insertEventsAndActivities(eventsAndActivities: EventsAndActivities)

    suspend fun updateEventsAndActivities(eventsAndActivities: EventsAndActivities)

    suspend fun deleteEventsAndActivities(eventsAndActivities: EventsAndActivities)

    fun getEventsAndActivities(): Flow<List<EventsAndActivities>>
}