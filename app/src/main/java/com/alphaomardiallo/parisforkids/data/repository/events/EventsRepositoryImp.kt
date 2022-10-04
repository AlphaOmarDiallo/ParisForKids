package com.alphaomardiallo.parisforkids.data.repository.events

import com.alphaomardiallo.parisforkids.data.local.EventsDAO
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsRepositoryImp @Inject constructor(
    private val eventsDAO: EventsDAO
) : EventsRepository {
    override suspend fun insertEvents(events: Events) {
        eventsDAO.insertEvents(events)
    }

    override suspend fun updateEvents(events: Events) {
        eventsDAO.updateEvents(events)
    }

    override suspend fun deleteEvents(events: Events) {
        eventsDAO.deleteEventsAndActivities(events)
    }

    override fun getEvents(): Flow<List<Events>> {
        return eventsDAO.getEvents()
    }
}