package com.alphaomardiallo.parisforkids.data.model.queFaireAParis

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventsAndActivities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "events_and_activities_id")
    val id: Long,
    @ColumnInfo(name = "events_and_response_data")
    val data: ResponseQueFaireAParis
)
