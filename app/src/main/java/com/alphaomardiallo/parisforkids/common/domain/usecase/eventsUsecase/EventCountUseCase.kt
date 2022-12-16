package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventCountUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun eventCount(): Flow<Int> {
        return eventsRepository.getEventsCount()
    }
}