package com.alphaomardiallo.parisforkids.ui.activity.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.Events
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.ResponseQueFaireAParis
import com.alphaomardiallo.parisforkids.data.model.weather.ResponseWeather
import com.alphaomardiallo.parisforkids.data.model.weather.Weather
import com.alphaomardiallo.parisforkids.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.data.repository.parisWeather.ParisWeatherRepository
import com.alphaomardiallo.parisforkids.data.repository.queFaireAParis.QueFaireAParisRepository
import com.alphaomardiallo.parisforkids.data.repository.weather.WeatherRepository
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
    private val eventsRepository: EventsRepository,
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    init {
        //checkIfListEventsWasUpdatedToday()
        //checkIfWeatherWasUpdatedToday()
    }

    //Events repository
    /**
     * If list was updated on the same day, no API call to refresh the list. Otherwise, yes.
     * The goal is to reduce the number of API calls
     */
    fun checkIfListEventsWasUpdatedToday() {
        viewModelScope.launch {
            Log.i(TAG, "checkIfListEventsWasUpdatedToday: here")
            if (eventsRepository.getEvents().first().isEmpty()) {
                fetchListEventsAndActivities()
            } else {
                val date1 = eventsRepository.getEvents().first()[0].date
                val date2 = DateUtil.createDate()
                if (!DateUtil.isItSameDay(date1, date2)) fetchListEventsAndActivities()
            }
        }
    }

    /**
     * If the list of events date is not the same as today's date, an API call is triggered.
     * The list is then added to the local database in order to make the app usable without network
     */
    private fun insertOrUpdateListEventsInDataBase(responseQueFaireAParis: ResponseQueFaireAParis) {
        viewModelScope.launch {
            Log.i(TAG, "insertOrUpdateListEventsInDataBase: here")
            if (eventsRepository.getEvents().first().isEmpty()) {
                val newEvents = Events(
                    0,
                    DateUtil.createDate(),
                    responseQueFaireAParis
                )
                eventsRepository.insertEvents(newEvents)
            } else {
                val oldEvents = eventsRepository.getEvents().first()[0]
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
            Log.i(TAG, "fetchListEventsAndActivities: here")
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
    /**
     * If the weather need an update, an API call is made to get the newer data set
     */
    private fun fetchParisWeather() {
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
                    insertOrUpdateWeatherInDataBase(response.body()!!)
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

    //Weather repository
    /**
     * Checking if the weather was updated on the same day, otherwise update it with an API call
     */
    fun checkIfWeatherWasUpdatedToday() {
        viewModelScope.launch {
            if (weatherRepository.getWeather().first().isEmpty()) {
                fetchParisWeather()
            } else {
                val date1 = weatherRepository.getWeather().first()[0].date
                val date2 = DateUtil.createDate()
                if (!DateUtil.isItSameDay(date1, date2)) fetchParisWeather()
            }
        }
    }

    /**
     * If the weather date is not the same as today's date, an API call is triggered.
     * The list is then added to the local database in order to make the app usable without network
     */
    private fun insertOrUpdateWeatherInDataBase(responseWeather: ResponseWeather) {
        viewModelScope.launch {
            if (weatherRepository.getWeather().first().isEmpty()) {
                val newWeather = Weather(
                    0,
                    responseWeather,
                    DateUtil.createDate()
                )
                weatherRepository.insertWeather(newWeather)
            } else {
                val oldWeather = weatherRepository.getWeather().first()[0]
                oldWeather.date = DateUtil.createDate()
                oldWeather.data = responseWeather
            }
        }
    }
}