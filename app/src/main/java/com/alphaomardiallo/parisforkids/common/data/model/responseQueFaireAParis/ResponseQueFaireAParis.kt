package com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis

data class ResponseQueFaireAParis(
    val facet_groups: List<FacetGroup>,
    val nhits: Int,
    val parameters: Parameters,
    val records: List<Record>
)