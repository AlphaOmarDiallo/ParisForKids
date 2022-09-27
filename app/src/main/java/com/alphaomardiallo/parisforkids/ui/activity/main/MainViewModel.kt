package com.alphaomardiallo.parisforkids.ui.activity.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.RecordsItem
import com.alphaomardiallo.parisforkids.data.repository.queFaireAParis.QueFaireAParisRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val queFaireAParisRepository: QueFaireAParisRepository
) : ViewModel() {

    init {
        getListEventsAndActivities()
    }

    /**
     * QFAP repository
     */
    private var _eventsAndActivities = mutableStateListOf<RecordsItem?>()
    val eventsAndActivities: List<RecordsItem?> = _eventsAndActivities

    private fun getListEventsAndActivities() {
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
                    updateEventsAndActivities(response.body()!!.records!!.toMutableStateList())
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

    private fun updateEventsAndActivities(list: SnapshotStateList<RecordsItem?>) {
        _eventsAndActivities = (list)
    }


}