package com.alphaomardiallo.parisforkids.ui.activity.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.ui.theme.ParisForKidsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = viewModel.eventsAndActivities
            Log.i(TAG, "onCreate: $list")
            ParisForKidsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun BottomNav(modifier: Modifier = Modifier) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.background,
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
        Greeting("Android")
    }
}