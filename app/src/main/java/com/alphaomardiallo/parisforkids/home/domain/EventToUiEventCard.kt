package com.alphaomardiallo.parisforkids.home.domain

import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event

fun Event.toUIEventCard(): UiEventCard {
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
        tags = this.tags,
        addressName = this.addressName,
        prm = this.prm,
        blind = this.blind,
        deaf = this.deaf
    )
}
