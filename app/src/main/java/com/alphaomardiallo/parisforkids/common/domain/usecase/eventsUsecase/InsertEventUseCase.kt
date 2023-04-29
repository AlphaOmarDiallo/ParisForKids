package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import javax.inject.Inject

class InsertEventUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    suspend fun execute(events: Event) {
        eventsRepository.insertEvents(events)
    }
}
