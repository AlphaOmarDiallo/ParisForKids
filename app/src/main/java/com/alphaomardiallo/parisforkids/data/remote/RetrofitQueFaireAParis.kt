package com.alphaomardiallo.parisforkids.data.remote

import com.alphaomardiallo.parisforkids.data.model.ResponseQueFaireAParis
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitQueFaireAParis {
    @GET("api/records/1.0/search/?")
    suspend fun queFaireAParisEventsAndActivity(
        @Query("dataset") dataSet: String,
        @Query("q") quantities: String,
        @Query("rows") rows: Int,
        @Query("facet") dateStart: String,
        @Query("facet") dateEnd: String,
        @Query("facet") tags: String,
        @Query("facet") addressName: String,
        @Query("facet") addressZipcode: String,
        @Query("facet") addressCity: String,
        @Query("facet") pmr: String,
        @Query("facet") blind: String,
        @Query("facet") deaf: String,
        @Query("facet") transport: String,
        @Query("facet") priceType: String,
        @Query("facet") accessType: String,
        @Query("facet") updatedAt: String,
        @Query("facet") programs: String,
    ): Response<ResponseQueFaireAParis>

}