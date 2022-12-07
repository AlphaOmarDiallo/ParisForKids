package com.alphaomardiallo.parisforkids.common.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.common.domain.model.queFaireAParis.ResponseQueFaireAParis
import retrofit2.Response

interface QueFaireAParisRepository {

    suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis>

}