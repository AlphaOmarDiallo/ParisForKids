package com.alphaomardiallo.parisforkids.ui.activity.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.ui.theme.ParisForKidsTheme
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
                    color = MaterialTheme.colors.background
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
fun Greeting(name: String, modifier: Modifier) {
    Text(text = "Hello $name!")
}

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
    ) {
        Greeting(name = "android", Modifier.padding(it))
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier, text: String) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(
                onClick = {/*TODO*/ },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = stringResource(id = R.string.top_app_bar_icon_content_description)
                    )
                }
            )
        },
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = text)
            }
        },
        actions = {
            TopAppBarActionButton(
                imageVector = Icons.Filled.Wifi,
                description = stringResource(id = R.string.top_app_bar_icon_wifi_content_description)
            ) {
                Log.i(TAG, "TopBar: was clicked")
            }
        }
    )
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

@Composable
fun BottomNav(modifier: Modifier = Modifier) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_list_all_activities)
                )
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_label_list_all_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Map,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_map_activities)
                )
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_label_map_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_search_activities)
                )
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_label_search_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = stringResource(id = R.string.bottom_navigation_content_description_favorite_activities)
                )
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_label_favorite_activities))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    ParisForKidsTheme {
        BottomNav()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParisForKidsTheme {
        TopBar(text = stringResource(id = R.string.app_name_formatted))
    }
}