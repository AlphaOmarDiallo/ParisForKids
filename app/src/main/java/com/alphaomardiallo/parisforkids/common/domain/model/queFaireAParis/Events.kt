package com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EventsAndActivities_table")
data class Events(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "events_and_activities_id")
    val id: Long,
    @ColumnInfo(name = "events_and_activities_creation_date")
    var date: String,
    @ColumnInfo(name = "events_and_response_data")
    var data: RecordsItem
)
