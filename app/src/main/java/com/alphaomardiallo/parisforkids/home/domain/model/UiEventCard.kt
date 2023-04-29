package com.alphaomardiallo.parisforkids.home.domain.model

import com.alphaomardiallo.parisforkids.common.domain.util.tags.TagsItem

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
    var tags: List<TagsItem?>?,
    var addressName: String?,
    var prm: Boolean,
    var blind: Boolean,
    var deaf: Boolean
)
