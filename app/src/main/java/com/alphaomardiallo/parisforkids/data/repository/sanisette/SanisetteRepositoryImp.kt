package com.alphaomardiallo.parisforkids.data.repository.sanisette

import com.alphaomardiallo.parisforkids.data.remote.RetrofitSanisette
import javax.inject.Inject

class SanisetteRepositoryImp @Inject constructor(
    private val retrofitSanisette: RetrofitSanisette
) : SanisetteRepository {
}