package com.alphaomardiallo.parisforkids.data.remote

import com.alphaomardiallo.parisforkids.data.model.ResponseQueFaireAParis
import com.alphaomardiallo.parisforkids.domain.Constant
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitQueFaireAParis {
    @GET(Constant.QFAPAPI)
    suspend fun queFaireAParisEventsAndActivity(): Response<ResponseQueFaireAParis>
}