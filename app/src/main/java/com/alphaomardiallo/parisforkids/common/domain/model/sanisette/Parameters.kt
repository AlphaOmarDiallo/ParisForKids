package com.alphaomardiallo.parisforkids.common.domain.model.sanisette

data class Parameters(
    val dataset: String,
    val facet: List<String>,
    val format: String,
    val rows: Int,
    val start: Int,
    val timezone: String
)