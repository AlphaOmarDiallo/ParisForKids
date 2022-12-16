package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsEventExistUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun eventExist(id: String): Flow<Boolean> {
        return eventsRepository.isEventExist(id)
    }
}