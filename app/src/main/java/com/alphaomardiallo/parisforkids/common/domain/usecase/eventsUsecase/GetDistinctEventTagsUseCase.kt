package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import javax.inject.Inject

class GetDistinctEventTagsUseCase @Inject constructor(
    val eventsRepository: EventsRepository
) {
    fun execute() = eventsRepository.selectDistinctTags()
}
