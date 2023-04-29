package com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EventsAndActivities_table")
data class Event(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "events_and_activities_id") val id: String,
    @ColumnInfo(name = "events_and_activities_creation_date") var creationDate: String,

    @ColumnInfo(name = "events_and_response_title_event") var titleEvent: String?,
    @ColumnInfo(name = "events_and_response_lead_text") var leadText: String?,
    @ColumnInfo(name = "events_and_response_tags") var tags: List<String?>?,
    @ColumnInfo(name = "events_and_response_description") var description: String?,

    @ColumnInfo(name = "events_and_response_url") var url: String?,
    @ColumnInfo(name = "events_and_response_access_link") var accessLink: String?,
    @ColumnInfo(name = "events_and_response_contact_url") var contactUrl: String?,
    @ColumnInfo(name = "events_and_response_contact_phone") var contactPhone: String?,
    @ColumnInfo(name = "events_and_response_contact_Facebook") var contactFacebook: String?,
    @ColumnInfo(name = "events_and_response_contact_Twitter") var contactTwitter: String?,

    @ColumnInfo(name = "events_and_response_access_type") var accessType: String?,
    @ColumnInfo(name = "events_and_response_price_type") var priceType: String?,
    @ColumnInfo(name = "events_and_response_price_detail") var priceDetail: String?,

    @ColumnInfo(name = "events_and_response_cover_url") var coverUrl: String?,
    @ColumnInfo(name = "events_and_response_cover_alt") var coverAlt: String?,
    @ColumnInfo(name = "events_and_response_cover_credit") var coverCredit: String?,

    @ColumnInfo(name = "events_and_response_latLong") var latLong: List<Double?>?,
    @ColumnInfo(name = "events_and_response_address_name") var addressName: String?,
    @ColumnInfo(name = "events_and_response_address_street") var addressStreet: String?,
    @ColumnInfo(name = "events_and_response_address_city") var addressCity: String?,
    @ColumnInfo(name = "events_and_response_address_zipcode") var addressZipcode: String?,

    /** api returns 1 accessibility when condition exists**/
    @ColumnInfo(name = "events_and_response_prm") var prm: Boolean = false,
    @ColumnInfo(name = "events_and_response_blind") var blind: Boolean = false,
    @ColumnInfo(name = "events_and_response_deaf") var deaf: Boolean = false,

    @ColumnInfo(name = "events_and_response_audience") var audience: String?,

    @ColumnInfo(name = "events_and_response_date_start") var dateStart: String?,
    @ColumnInfo(name = "events_and_response_date_end") var dateEnd: String?,
    @ColumnInfo(name = "events_and_response_date_description") var dateDescription: String?,
    @ColumnInfo(name = "events_and_response_date_occurrences") var occurrences: List<String?>?
)
