package com.alphaomardiallo.parisforkids.data.remote

import com.alphaomardiallo.parisforkids.data.model.queFaireAParis.ResponseQueFaireAParis
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitSanisette {
    @GET("api/records/1.0/search/?")
    suspend fun sanisetteList(
        @Query("dataset") dataSet: String,
        @Query("q") quantities: String,
        @Query("rows") rows: Int,
        @Query("facet") type: String,
        @Query("facet") statut: String,
        @Query("facet") arrondissement: String,
        @Query("facet") horaire: String,
        @Query("facet") acces_pmr: String,
        @Query("facet") relais_bebe: String
    ): Response<ResponseQueFaireAParis>

}