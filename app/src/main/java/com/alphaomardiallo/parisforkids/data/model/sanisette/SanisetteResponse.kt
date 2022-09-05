package com.alphaomardiallo.parisforkids.data.model.sanisette

data class SanisetteResponse(
    val facet_groups: List<FacetGroup>,
    val nhits: Int,
    val parameters: Parameters,
    val records: List<Record>
)