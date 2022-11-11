package com.alphaomardiallo.parisforkids.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.domain.model.queFaireAParis.ResponseQueFaireAParis
import retrofit2.Response

interface QueFaireAParisRepository {

    suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis>

}