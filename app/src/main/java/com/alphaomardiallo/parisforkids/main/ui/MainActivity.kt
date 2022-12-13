package com.alphaomardiallo.parisforkids.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.main.presenter.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            getData()

            ParisForKidsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

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
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
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
            MainContent()
            Navigation(navController)
            Button(onClick = {
                coroutineScope.launch {
                    val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                        message = "This is your message",
                        actionLabel = "Do something"
                    )
                    when (snackBarResult) {
                        SnackbarResult.Dismissed -> TODO()
                        SnackbarResult.ActionPerformed -> TODO()
                    }
                }
            }) {
                Text(text = "Click me!")
            }
        }
    }
}
//Previews
