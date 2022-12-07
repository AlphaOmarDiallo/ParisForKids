package com.alphaomardiallo.parisforkids.listActivities.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.common.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Events
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListActivitiesViewModel @Inject constructor(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    /**
     * Events and activities repository
     */
    private var _events = MutableLiveData<Events>()
    val events: LiveData<Events> = _events

    private fun getListEvents() {
        viewModelScope.launch {
            _events.value =
                eventsRepository.getEvents().first()[0]
        }
    }
}