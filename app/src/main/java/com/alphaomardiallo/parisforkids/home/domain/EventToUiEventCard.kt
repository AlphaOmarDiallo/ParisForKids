package com.alphaomardiallo.parisforkids.home.domain

import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event

class EventToUiEventCard {

    fun eventToUIEventCard(event: Event): UiEventCard {
        return UiEventCard(
            id = event.id,
            priceType = event.priceType,
            coverImage = event.coverUrl,
            coverCredit = event.coverCredit,
            zipcode = event.addressZipcode,
            leadText = event.leadText,
            title = event.titleEvent,
            audience = event.audience,
            dateDescription = event.dateDescription,
            tags = event.tags,
            addressName = event.addressName,
            prm = event.prm,
            blind = event.blind,
            deaf = event.deaf
        )
    }

}