package com.alphaomardiallo.parisforkids.home.presenter

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase.GetEventsUseCase
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import com.alphaomardiallo.parisforkids.home.domain.toUIEventCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val _eventStateFlow = MutableStateFlow(listOf<UiEventCard>())
    val eventStateFlow: StateFlow<List<UiEventCard>> get() = _eventStateFlow

    private fun getAllEventsAsState() {
        viewModelScope.launch {

            val allEventsList = getEventsUseCase.getAllEvents().first()

            val eventsList = mutableListOf<UiEventCard>()

            allEventsList.map { event ->
                eventsList.add(event.toUIEventCard(context))
            }
            _eventStateFlow.emit(eventsList)
        }
    }
}