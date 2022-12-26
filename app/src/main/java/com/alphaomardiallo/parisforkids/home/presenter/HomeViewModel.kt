package com.alphaomardiallo.parisforkids.home.presenter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase.GetEventsUseCase
import com.alphaomardiallo.parisforkids.home.domain.EventToUiEventCard
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
    private val eventToUiEventCard: EventToUiEventCard
) : ViewModel() {

    val allEventsAsUIEventCard: MutableState<List<UiEventCard>> = mutableStateOf(ArrayList())

    init {
        getAllEventsAsUiEventCard()
    }

    private fun getAllEventsAsUiEventCard(){
        val temp = mutableListOf<UiEventCard>()
        viewModelScope.launch {
            val allEvents = getEventsUseCase.getAllEvents()
            allEvents.map { eventList ->
                temp.add(eventToUiEventCard.eventToUIEventCard(event))
            }
        }
    }
}