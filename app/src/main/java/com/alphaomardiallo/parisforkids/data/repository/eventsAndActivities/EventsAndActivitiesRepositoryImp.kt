package com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities

import com.alphaomardiallo.parisforkids.data.local.EventsAndActivitiesDAO
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsAndActivitiesRepositoryImp @Inject constructor(
    private val eventsAndActivitiesDAO: EventsAndActivitiesDAO
) : EventsAndActivitiesRepository {
    override suspend fun insertEventsAndActivities(events: Events) {
        eventsAndActivitiesDAO.insertEventsAndActivities(events)
    }

    override suspend fun updateEventsAndActivities(events: Events) {
        eventsAndActivitiesDAO.updateEventsAndActivities(events)
    }

    override suspend fun deleteEventsAndActivities(events: Events) {
        eventsAndActivitiesDAO.deleteEventsAndActivities(events)
    }

    override fun getEventsAndActivities(): Flow<List<Events>> {
        return eventsAndActivitiesDAO.getEventsAndActivities()
    }
}