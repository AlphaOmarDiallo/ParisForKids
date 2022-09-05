package com.alphaomardiallo.parisforkids.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.data.model.ResponseQueFaireAParis
import com.alphaomardiallo.parisforkids.data.remote.RetrofitQueFaireAParis
import retrofit2.Response
import javax.inject.Inject

class QueFaireAParisRepositoryImp @Inject constructor(
    private val retrofitQueFaireAParis: RetrofitQueFaireAParis
) : QueFaireAParisRepository {

    override suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis> {
        return retrofitQueFaireAParis.queFaireAParisEventsAndActivity(
            "que-faire-a-paris-",
            "",
            999,
            "date_start",
            "date_end",
            "tags",
            "address_name",
            "address_zipcode",
            "address_city",
            "pmr",
            "blind",
            "deaf",
            "transport",
            "price_type",
            "access_type",
            "updated_at",
            "programs"
        )
    }

}