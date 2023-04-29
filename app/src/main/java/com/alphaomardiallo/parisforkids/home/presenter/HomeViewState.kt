package com.alphaomardiallo.parisforkids.home.presenter

import com.alphaomardiallo.parisforkids.home.domain.model.UiEventCard

data class HomeViewState(
    val eventsOfTheDay: List<UiEventCard> = emptyList(),
    val eventsByPeriod: List<UiEventCard> = emptyList(),
    // FIXME: create proper object to store theme
    val eventsByTheme: List<String> = emptyList()
)
