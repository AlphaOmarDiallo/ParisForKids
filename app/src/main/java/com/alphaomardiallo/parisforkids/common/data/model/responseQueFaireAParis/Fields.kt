package com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis

data class Fields(
    val access_link: String,
    val access_link_text: String,
    val access_type: String,
    val address_city: String,
    val address_name: String,
    val address_street: String,
    val address_text: String,
    val address_url: String,
    val address_url_text: String,
    val address_zipcode: String,
    val audience: String,
    val blind: Int,
    val childrens: String,
    val contact_facebook: String,
    val contact_mail: String,
    val contact_phone: String,
    val contact_twitter: String,
    val contact_url: String,
    val contributor_group: String,
    val cover_alt: String,
    val cover_credit: String,
    val cover_url: String,
    val date_description: String,
    val date_end: String,
    val date_start: String,
    val deaf: Int,
    val description: String,
    val id: String,
    val image_couverture: ImageCouverture,
    val lat_lon: List<Double>,
    val lead_text: String,
    val occurrences: String,
    val pmr: Int,
    val price_detail: String,
    val price_type: String,
    val programs: String,
    val tags: String,
    val title: String,
    val title_event: String,
    val transport: String,
    val updated_at: String,
    val url: String
)
