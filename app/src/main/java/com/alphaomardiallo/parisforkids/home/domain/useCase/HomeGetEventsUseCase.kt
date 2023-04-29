package com.alphaomardiallo.parisforkids.home.domain.useCase

import com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase.GetEventsUseCase
import javax.inject.Inject

class HomeGetEventsUseCase @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) {
    fun execute() = getEventsUseCase.execute()
}
