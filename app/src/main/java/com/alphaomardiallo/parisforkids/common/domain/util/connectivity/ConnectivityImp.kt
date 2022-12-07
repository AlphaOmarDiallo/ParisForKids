package com.alphaomardiallo.parisforkids.common.domain.util.connectivity

import android.content.ContentValues.TAG
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import com.alphaomardiallo.parisforkids.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConnectivityImp @Inject constructor(@ApplicationContext val context: Context) : Connectivity {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private var connectivityMessage: String = ""

    private var connectivityUnmetered: Boolean = false

    override fun observeConnectivity(): Flow<Connectivity.Status> {
        /**
         * Weak warning ignored because project does not build without
         * see error message : Not enough information to infer type variable T
         */
        return callbackFlow<Connectivity.Status> {
            val callback =
                object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        super.onAvailable(network)
                        launch {
                            send(Connectivity.Status.Available)
                            connectivityMessage = context.getString(R.string.connectivity_available)
                        }

                    }

                    override fun onLosing(network: Network, maxMsToLive: Int) {
                        super.onLosing(network, maxMsToLive)
                        launch {
                            send(Connectivity.Status.Losing)
                            connectivityMessage = context.getString(R.string.connectivity_losing)

                        }
                    }

                    override fun onLost(network: Network) {
                        super.onLost(network)
                        launch {
                            send(Connectivity.Status.Lost)
                            connectivityMessage = context.getString(R.string.connectivity_lost)
                        }
                    }

                    override fun onUnavailable() {
                        super.onUnavailable()
                        launch {
                            send(Connectivity.Status.Unavailable)
                            connectivityMessage =
                                context.getString(R.string.connectivity_unavailable)
                        }
                    }

                    override fun onCapabilitiesChanged(
                        network: Network,
                        networkCapabilities: NetworkCapabilities
                    ) {
                        super.onCapabilitiesChanged(network, networkCapabilities)
                        val unmetered: Boolean =
                            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
                        launch { connectivityUnmetered = unmetered }
                        Log.i(TAG, "onCapabilitiesChanged: $unmetered")
                    }
                }

            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()
    }

    override fun connectivityErrorMessage(): String = connectivityMessage

    override fun isConnexionUnmetered(): Boolean = connectivityUnmetered

}