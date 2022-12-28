package com.alphaomardiallo.parisforkids.home.domain

import android.content.Context
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import com.alphaomardiallo.parisforkids.common.domain.util.tags.TagsItem
import com.alphaomardiallo.parisforkids.common.domain.util.tags.formatToTag

fun Event.toUIEventCard(context: Context): UiEventCard {
    return UiEventCard(
        id = this.id,
        priceType = this.priceType,
        coverImage = this.coverUrl,
        coverCredit = this.coverCredit,
        zipcode = this.addressZipcode,
        leadText = this.leadText,
        title = this.titleEvent,
        audience = this.audience,
        dateDescription = this.dateDescription,
        tags = formatTags(this.tags, context),
        addressName = this.addressName,
        prm = this.prm,
        blind = this.blind,
        deaf = this.deaf
    )
}

private fun formatTags(tagList: List<String?>?, context: Context): List<TagsItem?>? {
    val tagsItemList = tagList?.map {
        formatToTag(tags = it, context = context)
    }
    return tagsItemList
}
