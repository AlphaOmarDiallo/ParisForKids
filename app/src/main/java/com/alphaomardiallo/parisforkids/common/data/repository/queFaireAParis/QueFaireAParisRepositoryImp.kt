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
            "que-faire-a-paris-",
            "",
            9999,
            "date_start",
            "date_end",
            "enfant",
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