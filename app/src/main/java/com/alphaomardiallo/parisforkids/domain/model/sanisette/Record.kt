package com.alphaomardiallo.parisforkids.domain.model.sanisette

data class Record(
    val datasetid: String,
    val fields: Fields,
    val geometry: Geometry,
    val record_timestamp: String,
    val recordid: String
)