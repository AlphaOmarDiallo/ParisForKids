package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import javax.inject.Inject

class UpdateEventUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    suspend fun updateEvent(events: Event) {
        eventsRepository.updateEvents(events)
    }
}