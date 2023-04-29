package com.alphaomardiallo.parisforkids.common.data.repository.queFaireAParis

import com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis.ResponseQueFaireAParis
import retrofit2.Response

interface QueFaireAParisRepository {

    suspend fun getListEventsAndActivities(): Response<ResponseQueFaireAParis>
}
