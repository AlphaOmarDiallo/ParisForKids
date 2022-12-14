package com.alphaomardiallo.parisforkids.home.presenter

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase.GetEventsUseCase
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import com.alphaomardiallo.parisforkids.home.domain.toUIEventCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val getEventsUseCase: GetEventsUseCase,
) : ViewModel() {

    init {
        getAllEventsAsState()
    }

    private val _eventState = mutableStateListOf<UiEventCard>()
    val eventState: List<UiEventCard> = _eventState

    private fun getAllEventsAsState() {
        viewModelScope.launch {
            val allEvents = getEventsUseCase.getAllEvents().first()
            allEvents.map { event ->
                _eventState.add(event.toUIEventCard(context))
            }
        }
    }
}