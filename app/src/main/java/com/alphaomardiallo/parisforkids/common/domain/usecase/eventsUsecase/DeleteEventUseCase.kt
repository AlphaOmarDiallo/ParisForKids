package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import javax.inject.Inject

class DeleteEventUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    private suspend fun deleteEvent(events: Events){
        eventsRepository.deleteEvents(events)
    }
}