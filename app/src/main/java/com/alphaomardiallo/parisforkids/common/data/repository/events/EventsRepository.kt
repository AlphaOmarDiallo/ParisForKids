package com.alphaomardiallo.parisforkids.common.data.repository.events

import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun insertEvents(events: Event)

    suspend fun updateEvents(events: Event)

    suspend fun deleteEvents(events: Event)

    fun getEventsCount(): Flow<Int>

    fun getEvents(): Flow<List<Event>>

    fun isEventExist(id: String): Flow<Boolean>

    fun loadSingleEvent(id: String): Flow<Event>
}