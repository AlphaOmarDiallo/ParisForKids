package com.alphaomardiallo.parisforkids.data.repository.events

import com.alphaomardiallo.parisforkids.data.local.EventsAndActivitiesDAO
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsRepositoryImp @Inject constructor(
    private val eventsAndActivitiesDAO: EventsAndActivitiesDAO
) : EventsRepository {
    override suspend fun insertEvents(events: Events) {
        eventsAndActivitiesDAO.insertEventsAndActivities(events)
    }

    override suspend fun updateEvents(events: Events) {
        eventsAndActivitiesDAO.updateEventsAndActivities(events)
    }

    override suspend fun deleteEvents(events: Events) {
        eventsAndActivitiesDAO.deleteEventsAndActivities(events)
    }

    override fun getEvents(): Flow<List<Events>> {
        return eventsAndActivitiesDAO.getEventsAndActivities()
    }
}