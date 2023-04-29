package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDistinctEventTagsUseCase @Inject constructor(
    val eventsRepository: EventsRepository
) {
    operator  fun invoke() : Flow<List<String>> {
        return eventsRepository.selectDistinctTags()
    }
}