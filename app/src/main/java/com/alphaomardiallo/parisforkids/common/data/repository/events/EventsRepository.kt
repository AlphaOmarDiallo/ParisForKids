package com.alphaomardiallo.parisforkids.common.data.repository.events

import com.alphaomardiallo.parisforkids.common.data.local.pagingSource.EventsPagingSource
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events

interface EventsRepository {

    suspend fun insertEvents(events: Events)

    suspend fun updateEvents(events: Events)

    suspend fun deleteEvents(events: Events)

    fun getEventsCount(): Int

    fun getEvents(): EventsPagingSource
}