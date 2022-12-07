package com.alphaomardiallo.parisforkids.common.data.repository.sanisette

import com.alphaomardiallo.parisforkids.common.data.remote.RetrofitSanisette
import javax.inject.Inject

class SanisetteRepositoryImp @Inject constructor(
    private val retrofitSanisette: RetrofitSanisette
) : SanisetteRepository {
}