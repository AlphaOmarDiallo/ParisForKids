package com.alphaomardiallo.parisforkids.common.data.repository.events

import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun insertEvents(events: Events)

    suspend fun updateEvents(events: Events)

    suspend fun deleteEvents(events: Events)

    fun getEventsCount(): Flow<Int>

    fun getEvents(): Flow<List<Events>>
}