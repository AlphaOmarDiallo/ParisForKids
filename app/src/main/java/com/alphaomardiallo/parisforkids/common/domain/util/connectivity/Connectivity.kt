package com.alphaomardiallo.parisforkids.common.domain.util.connectivity

import kotlinx.coroutines.flow.Flow

interface Connectivity {
    fun observeConnectivity(): Flow<Status>

    fun connectivityErrorMessage(): String

    fun isConnexionUnmetered(): Boolean

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}
