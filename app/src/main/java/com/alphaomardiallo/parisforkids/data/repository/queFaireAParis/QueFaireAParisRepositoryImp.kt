package com.alphaomardiallo.parisforkids.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.data.model.ResponseQueFaireAParis
import com.alphaomardiallo.parisforkids.data.remote.RetrofitQueFaireAParis
import retrofit2.Response
import javax.inject.Inject

class QueFaireAParisRepositoryImp @Inject constructor(
    private val retrofitQueFaireAParis: RetrofitQueFaireAParis
) : QueFaireAParisRepository {

    override suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis> {
        return retrofitQueFaireAParis.queFaireAParisEventsAndActivity()
    }

}