package com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities

import com.alphaomardiallo.parisforkids.data.local.EventsAndActivitiesDAO
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.EventsAndActivities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsAndActivitiesRepositoryImp @Inject constructor(
    private val eventsAndActivitiesDAO: EventsAndActivitiesDAO
) : EventsAndActivitiesRepository {
    override suspend fun insertEventsAndActivities(eventsAndActivities: EventsAndActivities) {
        eventsAndActivitiesDAO.insertEventsAndActivities(eventsAndActivities)
    }

    override suspend fun updateEventsAndActivities(eventsAndActivities: EventsAndActivities) {
        eventsAndActivitiesDAO.updateEventsAndActivities(eventsAndActivities)
    }

    override suspend fun deleteEventsAndActivities(eventsAndActivities: EventsAndActivities) {
        eventsAndActivitiesDAO.deleteEventsAndActivities(eventsAndActivities)
    }

    override fun getEventsAndActivities(): Flow<List<EventsAndActivities>> {
        return eventsAndActivitiesDAO.getEventsAndActivities()
    }
}