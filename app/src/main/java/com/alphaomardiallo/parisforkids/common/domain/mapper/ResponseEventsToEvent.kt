package com.alphaomardiallo.parisforkids.common.domain.mapper

import com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis.Record
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.Event
import com.alphaomardiallo.parisforkids.common.domain.util.date.DateUtil
import javax.inject.Inject

class ResponseEventsToEvent @Inject constructor(
    private val dateUtil: DateUtil
) {

    fun responseEventsToEvent(record: Record): Event {
        return Event(
            id = record.recordid,
            creationDate = dateUtil.createDate(),
            titleEvent = record.fields.title,
            leadText = record.fields.lead_text,
            tags = stringToList(record.fields.tags),
            description = record.fields.description,
            url = record.fields.url,
            accessLink = record.fields.access_link,
            contactUrl = record.fields.contact_url,
            accessType = record.fields.access_type,
            priceType = record.fields.price_type,
            priceDetail = record.fields.price_detail,
            coverUrl = record.fields.cover_url,
            coverAlt = record.fields.cover_alt,
            coverCredit = record.fields.cover_credit,
            latLong = record.fields.lat_lon,
            addressName = record.fields.address_name,
            addressStreet = record.fields.address_street,
            addressCity = record.fields.address_city,
            addressZipcode = record.fields.address_zipcode,
            audience = record.fields.audience,
            prm = checkForAccessibility(record.fields.pmr),
            blind = checkForAccessibility(record.fields.blind),
            deaf = checkForAccessibility(record.fields.deaf),
            contactPhone = record.fields.contact_phone,
            contactFacebook = record.fields.contact_facebook,
            contactTwitter = record.fields.contact_twitter,
            dateStart = record.fields.date_start,
            dateEnd = record.fields.date_end,
            dateDescription = record.fields.date_description,
            occurrences = stringDateToList(record.fields.occurrences)
        )
    }

    private fun checkForAccessibility(check: Int?): Boolean {
        return if (check != null) {
            when (check) {
                1 -> true
                else -> false
            }
        } else {
            false
        }
    }

    private fun stringToList(string: String?): List<String> {
        return if (string != null) listOf(*string.split(";").toTypedArray()) else listOf()
    }

    private fun stringDateToList(string: String?): List<String> {
        return if (string != null) listOf(*string.split("_").toTypedArray()) else listOf()
    }
}