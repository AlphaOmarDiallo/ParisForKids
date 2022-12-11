package com.alphaomardiallo.parisforkids.common.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.common.data.remote.RetrofitQueFaireAParis
import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.ResponseQueFaireAParis
import retrofit2.Response
import javax.inject.Inject

class QueFaireAParisRepositoryImp @Inject constructor(
    private val retrofitQueFaireAParis: RetrofitQueFaireAParis
) : QueFaireAParisRepository {

    override suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis> {
        return retrofitQueFaireAParis.queFaireAParisEventsAndActivity(
            dataSet = "que-faire-a-paris-",
            quantities = "",
            rows = 1000,
            dateStart = "date_start",
            dateEnd = "date_end",
            tags = "enfant",
            addressName = "address_name",
            addressZipcode = "address_zipcode",
            addressCity = "address_city",
            pmr = "pmr",
            blind = "blind",
            deaf = "deaf",
            transport = "transport",
            priceType = "price_type",
            accessType = "access_type",
            updatedAt = "updated_at",
            programs = "programs",
            refineTags = "Enfants",
            timezone = "Europe/Paris"
        )
    }

}