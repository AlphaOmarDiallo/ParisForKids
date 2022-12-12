package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import javax.inject.Inject

class EventCountUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun eventCount(): Int {
        return eventsRepository.getEventsCount()
    }
}