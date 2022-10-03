package com.alphaomardiallo.parisforkids.ui.activity.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.EventsAndActivities
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.ResponseQueFaireAParis
import com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities.EventsAndActivitiesRepository
import com.alphaomardiallo.parisforkids.data.repository.parisWeather.ParisWeatherRepository
import com.alphaomardiallo.parisforkids.data.repository.queFaireAParis.QueFaireAParisRepository
import com.alphaomardiallo.parisforkids.domain.DateUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val queFaireAParisRepository: QueFaireAParisRepository,
    private val parisWeatherRepository: ParisWeatherRepository,
    private val eventsAndActivitiesRepository: EventsAndActivitiesRepository
) : ViewModel() {

    init {
        checkIfListEventsWasUpdatedToday()
        getParisWeather()
    }

    //Events and activities repository

    /**
     * If list was updated on the same day, no API call to refresh the list. Otherwise, yes.
     * The goal is to reduce the number of API calls
     */
    private fun checkIfListEventsWasUpdatedToday() {
        viewModelScope.launch {
            val date1 = eventsAndActivitiesRepository.getEventsAndActivities().first()[0].date
            val date2 = DateUtil.createDate()
            if (!DateUtil.isItSameDay(date1, date2)) fetchListEventsAndActivities()
        }
    }

    /**
     * If the list of events date is not the same as today's date, an API call is triggered.
     * The list is then added to the local database in order to make the app usable without network
     */
    private fun insertOrUpdateListEventsInDataBase(responseQueFaireAParis: ResponseQueFaireAParis) {
        viewModelScope.launch {

            if (eventsAndActivitiesRepository.getEventsAndActivities().first().isEmpty()) {
                val newEvents = EventsAndActivities(
                    0,
                    DateUtil.createDate(),
                    responseQueFaireAParis
                )
                eventsAndActivitiesRepository.insertEventsAndActivities(newEvents)
            } else {
                val oldEvents = eventsAndActivitiesRepository.getEventsAndActivities().first()[0]
                oldEvents.date = DateUtil.createDate()
                oldEvents.data = responseQueFaireAParis
            }

        }
    }

    // Que Faire A Paris repository

    /**
     * API call to open data Paris in order to fetch list of events que faire a paris.
     * Once fetch successfully, the list is then added to the local database.
     */
    private fun fetchListEventsAndActivities() {
        viewModelScope.launch {
            try {
                val response = queFaireAParisRepository.getListEventsAndActivities()

                if (!response.isSuccessful) {
                    Log.w(
                        TAG,
                        "getListEventsAndActivities: no response from que faire a paris API",
                        null
                    )
                    return@launch
                }

                if (response.body()?.records != null) {
                    insertOrUpdateListEventsInDataBase(response.body()!!)
                } else {
                    Log.w(TAG, "getListEventsAndActivities: events and activity list in null", null)
                }
            } catch (exception: IOException) {
                Log.e(TAG, "getListEventsAndActivities: IOException = ${exception.message}", null)
            } catch (exception: HttpException) {
                Log.e(TAG, "getListEventsAndActivities: HttpException = ${exception.message}", null)
            }
        }
    }



    // Paris Weather repository

    private fun getParisWeather() {
        viewModelScope.launch {
            try {
                val response = parisWeatherRepository.getParisWeather()

                if (!response.isSuccessful) {
                    Log.w(
                        TAG,
                        "getParisWeather: no response from que faire a paris API",
                        null
                    )
                    return@launch
                }

                if (response.body()?.currentWeather != null) {
                    Log.i(
                        TAG,
                        "getParisWeather: ${response.body()!!.daily?.temperature2mMax.toString()}"
                    )
                } else {
                    Log.w(TAG, "getParisWeather: events and activity list in null", null)
                }
            } catch (exception: IOException) {
                Log.e(TAG, "getParisWeather: IOException = ${exception.message}", null)
            } catch (exception: HttpException) {
                Log.e(TAG, "getParisWeather: HttpException = ${exception.message}", null)
            }
        }
    }
}