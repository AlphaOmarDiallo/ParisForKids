package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import javax.inject.Inject

class IsEventExistUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun execute(id: String) = eventsRepository.isEventExist(id)
}
