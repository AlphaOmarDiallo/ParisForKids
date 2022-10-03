package com.alphaomardiallo.parisforkids.data.repository.events

import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun insertEvents(events: Events)

    suspend fun updateEvents(events: Events)

    suspend fun deleteEvents(events: Events)

    fun getEvents(): Flow<List<Events>>
}