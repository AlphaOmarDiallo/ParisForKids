package com.alphaomardiallo.parisforkids.home.domain

data class UiEventCard(
    val id: String,
    var priceType: String?,
    var coverImage: String?,
    var coverCredit: String?,
    var zipcode: String?,
    var leadText: String?,
    var title: String?,
    var audience: String?,
    var dateDescription: String?,
    var tags: List<String?>?,
    var addressName: String?,
    var prm: Boolean,
    var blind: Boolean,
    var deaf: Boolean
)
