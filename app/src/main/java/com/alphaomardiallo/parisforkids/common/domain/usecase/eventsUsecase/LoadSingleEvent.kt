package com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase

import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadSingleEvent @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun loadSingleEvent(id: String): Flow<Events> {
        return eventsRepository.loadSingleEvent(id)
    }
}