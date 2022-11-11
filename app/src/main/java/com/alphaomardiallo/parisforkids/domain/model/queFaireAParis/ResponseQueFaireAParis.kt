package com.alphaomardiallo.parisforkids.domain.model.queFaireAParis

data class ResponseQueFaireAParis(
    val nhits: Int? = null,
    val facetGroups: List<FacetGroupsItem?>? = null,
    val records: List<RecordsItem?>? = null,
    val parameters: Parameters? = null
)

data class Parameters(
    val timezone: String? = null,
    val start: Int? = null,
    val format: String? = null,
    val rows: Int? = null,
    val dataset: String? = null,
    val facet: List<String?>? = null
)

data class Geometry(
    val coordinates: List<Double?>? = null,
    val type: String? = null
)

data class FacetsItem(
    val path: String? = null,
    val name: String? = null,
    val count: Int? = null,
    val state: String? = null
)

data class RecordsItem(
    val recordid: String? = null,
    val datasetid: String? = null,
    val geometry: Geometry? = null,
    val fields: Fields? = null,
    val recordTimestamp: String? = null
)

data class FacetGroupsItem(
    val name: String? = null,
    val facets: List<FacetsItem?>? = null
)

data class ImageCouverture(
    val thumbnail: Boolean? = null,
    val filename: String? = null,
    val width: Int? = null,
    val format: String? = null,
    val mimetype: String? = null,
    val id: String? = null,
    val height: Int? = null,
    val colorSummary: List<String?>? = null
)

data class Fields(
    val occurrences: String? = null,
    val accessType: String? = null,
    val contactFacebook: String? = null,
    val contactPhone: String? = null,
    val description: String? = null,
    val titleEvent: String? = null,
    val addressName: String? = null,
    val title: String? = null,
    val coverCredit: String? = null,
    val updatedAt: String? = null,
    val addressZipcode: String? = null,
    val id: String? = null,
    val dateDescription: String? = null,
    val latLon: List<Double?>? = null,
    val contactMail: String? = null,
    val coverUrl: String? = null,
    val audience: String? = null,
    val coverAlt: String? = null,
    val contactUrl: String? = null,
    val contributorGroup: String? = null,
    val dateEnd: String? = null,
    val url: String? = null,
    val tags: String? = null,
    val addressCity: String? = null,
    val dateStart: String? = null,
    val imageCouverture: ImageCouverture? = null,
    val addressStreet: String? = null,
    val leadText: String? = null,
    val priceType: String? = null,
    val accessLink: String? = null,
    val priceDetail: String? = null,
    val addressText: String? = null,
    val accessLinkText: String? = null,
    val contactTwitter: String? = null,
    val pmr: Int? = null,
    val blind: Int? = null
)

