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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val getEventsUseCase: GetEventsUseCase,
    private val getDistinctEventTagsUseCase: GetDistinctEventTagsUseCase
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

    private val _distinctTagsStateFlow = MutableStateFlow(listOf<String>())
    val distinctTagsStateFlow: StateFlow<List<String>> get() = _distinctTagsStateFlow

    private fun getDistinctTags() {
        viewModelScope.launch {
            val distinctTags = getDistinctEventTagsUseCase.invoke().first()

            val temp = mutableListOf<String>()

            distinctTags.let {
                it.map { tagString ->
                    val tagStringToArray = tagString.split(",").toMutableList()

                    tagStringToArray.map { value ->
                        if (!temp.contains(value)) temp.add(value)
                    }
                }
            }

            _distinctTagsStateFlow.emit(temp)
        }
    }

}