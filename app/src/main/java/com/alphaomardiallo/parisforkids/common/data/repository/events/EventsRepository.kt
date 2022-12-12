package com.alphaomardiallo.parisforkids.common.data.repository.events

import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun insertEvents(events: Events)

    suspend fun updateEvents(events: Events)

    suspend fun deleteEvents(events: Events)

    fun getEventsCount(): Int

    fun getEvents(): Flow<List<Events>>

    fun isEventExist(id: String): Boolean

    fun loadSingleEvent(id: String): Events
}