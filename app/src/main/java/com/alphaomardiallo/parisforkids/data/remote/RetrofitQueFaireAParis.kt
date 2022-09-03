package com.alphaomardiallo.parisforkids.data.remote

import com.alphaomardiallo.parisforkids.data.model.ResponseQueFaireAParis
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitQueFaireAParis {
    @GET
    suspend fun queFaireAParisEventsAndActivity(): Response<ResponseQueFaireAParis>
}