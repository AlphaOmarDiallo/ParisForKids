package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import javax.inject.Inject

class InsertEventUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
){
    suspend fun insertEvent(events: Events){
        eventsRepository.insertEvents(events)
    }
}