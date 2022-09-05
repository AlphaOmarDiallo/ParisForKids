package com.alphaomardiallo.parisforkids.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.ResponseQueFaireAParis
import retrofit2.Response

interface QueFaireAParisRepository {

    suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis>

}