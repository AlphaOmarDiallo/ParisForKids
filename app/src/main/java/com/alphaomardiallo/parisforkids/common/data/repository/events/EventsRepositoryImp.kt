package com.alphaomardiallo.parisforkids.common.data.repository.events

import com.alphaomardiallo.parisforkids.common.data.local.dao.EventsDAO
import com.alphaomardiallo.parisforkids.common.data.local.pagingSource.EventsPagingSource
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
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

    override fun getEventsCount(): Int {
        return eventsDAO.getEventsCount()
    }

    override fun getEvents(): EventsPagingSource {
        return eventsDAO.getEvents()
    }


}