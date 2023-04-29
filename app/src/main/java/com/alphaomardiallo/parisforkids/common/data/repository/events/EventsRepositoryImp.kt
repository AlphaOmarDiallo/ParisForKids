package com.alphaomardiallo.parisforkids.common.data.repository.events

import com.alphaomardiallo.parisforkids.common.data.local.dao.EventsDAO
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsRepositoryImp @Inject constructor(
    private val eventsDAO: EventsDAO
) : EventsRepository {
    override suspend fun insertEvents(events: Event) {
        eventsDAO.insertEvents(events)
    }

    override suspend fun updateEvents(events: Event) {
        eventsDAO.updateEvents(events)
    }

    override suspend fun deleteEvents(events: Event) {
        eventsDAO.deleteEventsAndActivities(events)
    }

    override fun getEventsCount(): Flow<Int> {
        return eventsDAO.getEventsCount()
    }

    override fun getEvents(): Flow<List<Event>> {
        return eventsDAO.getEvents()
    }

    override fun isEventExist(id: String): Flow<Boolean> {
        return eventsDAO.isEventExist(id)
    }

    override fun loadSingleEvent(id: String): Flow<Event> {
        return eventsDAO.loadSingleEvent(id)
    }

    override fun selectDistinctTags(): Flow<List<String>> {
        return eventsDAO.selectDistinctTags()
    }

}