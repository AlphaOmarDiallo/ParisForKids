package com.alphaomardiallo.parisforkids.home.presenter

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase.GetDistinctEventTagsUseCase
import com.alphaomardiallo.parisforkids.common.domain.usecase.eventsUsecase.GetEventsUseCase
import com.alphaomardiallo.parisforkids.home.domain.UiEventCard
import com.alphaomardiallo.parisforkids.home.domain.toUIEventCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: Put comments on ViewModel
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val getEventsUseCase: GetEventsUseCase,
    private val getDistinctEventTagsUseCase: GetDistinctEventTagsUseCase
) : ViewModel() {

    init {
        getAllEvents()
    }

    private val _eventViewState = MutableStateFlow(HomeViewState())
    val eventViewState: StateFlow<HomeViewState> get() = _eventViewState

    private fun getAllEvents() {
        viewModelScope.launch {
            getEventsUseCase.execute().collect { eventsList ->
                val uiEventsList = mutableListOf<UiEventCard>()
                eventsList.map { event ->
                    // FIXME: remove context, find another solution. Leaks
                    uiEventsList.add(event.toUIEventCard(context))
                }
                _eventViewState.value = _eventViewState.value.copy(eventsOfTheDay = uiEventsList)
            }
        }
    }

    // FIXME: Bad method, must be done straight via SQL query
    private fun getDistinctTags() {
        viewModelScope.launch {
            getDistinctEventTagsUseCase.execute().collect { tagList ->
                val uiTagList = mutableListOf<String>()
                tagList.map { tag ->
                    val tagStringToArray = tag.split(",").toMutableList()
                    tagStringToArray.map { value ->
                        if (!uiTagList.contains(value)) uiTagList.add(value)
                    }
                }
                _eventViewState.value = _eventViewState.value.copy(eventsByTheme = uiTagList)
            }
        }
    }
}
