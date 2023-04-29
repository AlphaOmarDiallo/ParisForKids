package com.alphaomardiallo.parisforkids.common.main.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.common.main.presenter.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getData()
            ParisForKidsTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen()
                }
            }
        }
    }

    private fun getData() {
        viewModel.checkIfListEventsWasUpdatedToday()
        viewModel.checkIfWeatherWasUpdatedToday()
        viewModel.monitorNetworkStatus()
    }
}

// Composable

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(text = stringResource(id = R.string.app_name_formatted))
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Navigation(navController)
        }
    }
}

private fun handleSnackBarResult(
    snackBarResult: SnackbarResult?
) {
    when (snackBarResult) {
        SnackbarResult.Dismissed -> Log.e(TAG, "handleSnackBarResult: ${snackBarResult.name}", null)
        SnackbarResult.ActionPerformed -> Log.e(
            TAG,
            "handleSnackBarResult: ${snackBarResult.name}",
            null
        )

        else -> {}
    }
}
