package com.alphaomardiallo.parisforkids.ui.fragments.listActivities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities.EventsAndActivitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListActivitiesViewModel @Inject constructor(
    private val eventsAndActivitiesRepository: EventsAndActivitiesRepository
) : ViewModel() {

    /**
     * Events and activities repository
     */
    private var _events = MutableLiveData<Events>()
    val events: LiveData<Events> = _events

    private fun getListEventsAndActivities() {
        viewModelScope.launch {
            _events.value =
                eventsAndActivitiesRepository.getEventsAndActivities().first()[0]
        }
    }
}