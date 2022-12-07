package com.alphaomardiallo.parisforkids.common.domain.model.sanisette

data class Fields(
    val acces_pmr: String,
    val adresse: String,
    val arrondissement: String,
    val geo_point_2d: List<Double>,
    val geo_shape: GeoShape,
    val horaire: String,
    val relais_bebe: String,
    val type: String,
    val url_fiche_equipement: String
)