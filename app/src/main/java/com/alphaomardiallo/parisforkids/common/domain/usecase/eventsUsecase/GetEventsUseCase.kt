package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun getAllEvents(): Flow<List<Events>> {
        return eventsRepository.getEvents()
    }
}