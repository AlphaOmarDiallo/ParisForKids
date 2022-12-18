package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import javax.inject.Inject

class DeleteEventUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    private suspend fun deleteEvent(events: Event) {
        eventsRepository.deleteEvents(events)
    }
}