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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import com.alphaomardiallo.parisforkids.main.presenter.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            viewModel.checkIfListEventsWasUpdatedToday()
            viewModel.checkIfWeatherWasUpdatedToday()
            viewModel.monitorNetworkStatus()

            ParisForKidsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                    ) {
                    Layout(navController = navController, startDestination = "ListActivities")
                }
            }
        }
    }
}

private fun getData() {
}

/**
 * Composables
 */


@Composable
fun Layout(
    navController: NavHostController,
    startDestination: String
) {
    Scaffold(
        topBar = {
            TopBar(text = stringResource(id = R.string.app_name_formatted))
        },
        bottomBar = {
            BottomNav()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            MainContent(modifier = Modifier)
        }
    }
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = ""
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

    }
}

//Previews

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParisForKidsTheme {
        TopBar(text = stringResource(id = R.string.app_name_formatted))
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    ParisForKidsTheme {
        MainContent(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    ParisForKidsTheme {
        BottomNav()
    }
}